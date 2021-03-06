package liquibase.actionlogic.core.mysql;

import liquibase.Scope;
import liquibase.action.core.RenameViewAction;
import liquibase.actionlogic.core.RenameViewLogic;
import liquibase.database.Database;
import liquibase.database.core.mysql.MysqlDatabase;
import liquibase.util.StringClauses;

public class RenameViewLogicMysql extends RenameViewLogic {

    @Override
    protected Class<? extends Database> getRequiredDatabase() {
        return MysqlDatabase.class;
    }

    @Override
    protected StringClauses generateSql(RenameViewAction action, Scope scope) {
        return super.generateSql(action, scope).replace("VIEW", "TABLE");
    }
}
