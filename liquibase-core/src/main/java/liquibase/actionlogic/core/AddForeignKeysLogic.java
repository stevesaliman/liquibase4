package liquibase.actionlogic.core;

import liquibase.Scope;
import liquibase.action.Action;
import liquibase.action.ActionStatus;
import liquibase.action.core.AddForeignKeysAction;
import liquibase.action.core.AlterTableAction;
import liquibase.actionlogic.AbstractActionLogic;
import liquibase.actionlogic.ActionResult;
import liquibase.actionlogic.DelegateResult;
import liquibase.database.Database;
import liquibase.exception.ActionPerformException;
import liquibase.exception.UnexpectedLiquibaseException;
import liquibase.ValidationErrors;
import liquibase.snapshot.SnapshotFactory;
import liquibase.structure.core.Column;
import liquibase.structure.core.ForeignKey;
import liquibase.util.ObjectUtil;
import liquibase.util.StringClauses;
import liquibase.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddForeignKeysLogic extends AbstractActionLogic<AddForeignKeysAction> {

    public enum Clauses {
        constraintName,
        baseColumnNames, referencedTableName, referencedColumnNames,
    }

    @Override
    protected Class<AddForeignKeysAction> getSupportedAction() {
        return AddForeignKeysAction.class;
    }

    @Override
    public ValidationErrors validate(AddForeignKeysAction action, Scope scope) {
        ValidationErrors validationErrors = super.validate(action, scope)
                .checkRequiredFields("foreignKeys.table", "foreignKeys.table.name",
                        "foreignKeys.referencedTable","foreignKeys.referencedTable.name",
                        "foreignKeys.columnChecks", "foreignKeys.columnChecks.baseColumn", "foreignKeys.columnChecks.referencedColumn");

        Database database = scope.getDatabase();

        if (!database.supports(Database.Feature.DEFERRABLE_CONSTRAINTS, scope)) {
            validationErrors.checkUnsupportedFields("foreignKeys.initiallyDeferred", "foreignKeys.deferrable");
        }

        validationErrors.checkField("foreignKeys", new ValidationErrors.FieldCheck<ForeignKey>() {
            @Override
            public String check(ForeignKey fk) {
                if (fk.table.container != null && fk.referencedTable.container != null && !supportsSeparateConstraintSchema() && !fk.table.container.equals(fk.referencedTable.container, true)) {
                    return "cannot specify a different foreign key schema";
                }
                return null;
            }
        });

        return validationErrors;
    }

    public boolean supportsSeparateConstraintSchema() {
        return false;
    }

    @Override
    public ActionStatus checkStatus(AddForeignKeysAction action, Scope scope) {
        ActionStatus result = new ActionStatus();
        try {
            for (ForeignKey actionFK : action.foreignKeys) {
                ForeignKey snapshotFK = scope.getSingleton(SnapshotFactory.class).snapshot(ForeignKey.class, actionFK.toReference(), scope);
                if (snapshotFK == null) {
                    result.assertApplied(false, "Foreign Key '" + actionFK.name + "' not found");
                } else {
                    result.assertCorrect(actionFK, snapshotFK);
                    if (actionFK.columnChecks.size() == snapshotFK.columnChecks.size()) {
                        for (int i=0; i <  actionFK.columnChecks.size(); i++) {
                            result.assertCorrect(actionFK.columnChecks.get(i), snapshotFK.columnChecks.get(i));
                        }
                    } else {
                        result.assertCorrect(false, "columnCheck sizes are different");
                    }
                }
            }
            return result;
        } catch (Throwable e) {
            return result.unknown(e);
        }
    }

    @Override
    public ActionResult execute(AddForeignKeysAction action, Scope scope) throws ActionPerformException {

        List<Action> actions = new ArrayList<>();

        for (ForeignKey fk : action.foreignKeys) {
            if (fk == null) {
                continue;
            }

            actions.addAll(Arrays.asList(execute(fk, action, scope)));
        }

        return new DelegateResult(action, null, actions.toArray(new Action[actions.size()]));
    }

    protected Action execute(ForeignKey fk, AddForeignKeysAction action, Scope scope) {
        return new AlterTableAction(
                fk.table,
                generateConstraintClause(fk, action, scope)
        );
    }


    public StringClauses generateConstraintClause(ForeignKey foreignKey, AddForeignKeysAction action, final Scope scope) {
        final Database database = scope.getDatabase();

        String constrantName = supportsSeparateConstraintSchema() ? database.quoteObjectName(foreignKey.name, ForeignKey.class, scope) : database.quoteObjectName(foreignKey.getName(), ForeignKey.class, scope);

        StringClauses clauses = new StringClauses()
                .append("ADD")
                .append("CONSTRAINT")
                .append(AddForeignKeysLogic.Clauses.constraintName, constrantName)
                .append("FOREIGN KEY")
                .append(Clauses.baseColumnNames, "(" + StringUtils.join(foreignKey.columnChecks, ", ", new StringUtils.StringUtilsFormatter<ForeignKey.ForeignKeyColumnCheck>() {
                    @Override
                    public String toString(ForeignKey.ForeignKeyColumnCheck obj) {
                        return database.quoteObjectName(obj.baseColumn, Column.class, scope);
                    }
                }) + ")")
                .append("REFERENCES")
                .append(Clauses.referencedTableName, database.quoteObjectName(foreignKey.referencedTable, scope))
                .append(Clauses.referencedColumnNames, "(" + StringUtils.join(foreignKey.columnChecks, ", ", new StringUtils.StringUtilsFormatter<ForeignKey.ForeignKeyColumnCheck>() {
                    @Override
                    public String toString(ForeignKey.ForeignKeyColumnCheck obj) {
                        return database.quoteObjectName(obj.referencedColumn, Column.class, scope);
                    }
                }) + ")");

        if (foreignKey.deleteRule != null) {
            String option;
            switch (foreignKey.deleteRule) {
                case importedKeyCascade: option = "CASCADE"; break;
                case importedKeyNoAction: option = "NO ACTION"; break;
                case importedKeyRestrict: option = "RESTRICT"; break;
                case importedKeySetDefault: option = "SET DEFAULT"; break;
                case importedKeySetNull: option = "SET NULL"; break;
                default: throw new UnexpectedLiquibaseException("Unknown updateRule: "+foreignKey.updateRule);
            }
            clauses.append("ON DELETE", new StringClauses(" ").append("ON DELETE").append(option));
        }

        if (foreignKey.updateRule != null) {
            String option;
            switch (foreignKey.updateRule) {
                case importedKeyCascade: option = "CASCADE"; break;
                case importedKeySetNull: option = "SET NULL"; break;
                case importedKeySetDefault: option = "SET DEFAULT"; break;
                case importedKeyRestrict: option = "RESTRICT"; break;
                case importedKeyNoAction: option = "NO ACTION"; break;
                default: throw new UnexpectedLiquibaseException("Unknown updateRule: "+foreignKey.updateRule);
            }
            clauses.append("ON UPDATE", new StringClauses(" ").append("ON UPDATE").append(option));
        }

        boolean deferrable = ObjectUtil.defaultIfEmpty(foreignKey.deferrable, false);
        boolean initiallyDeferred = ObjectUtil.defaultIfEmpty(foreignKey.initiallyDeferred, false);
        if (deferrable || initiallyDeferred) {
            if (deferrable) {
                clauses.append("DEFERRABLE");
            }

            if (initiallyDeferred) {
                clauses.append("INITIALLY DEFERRED");
            }
        }

        return clauses;
    }
}
