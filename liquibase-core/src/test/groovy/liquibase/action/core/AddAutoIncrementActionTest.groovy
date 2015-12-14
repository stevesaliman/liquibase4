package liquibase.action.core

import liquibase.JUnitScope
import liquibase.Scope
import liquibase.action.AbstractActionTest
import liquibase.action.Action
import liquibase.database.ConnectionSupplier
import liquibase.snapshot.Snapshot
import liquibase.structure.ObjectNameStrategy
import liquibase.structure.ObjectReference
import liquibase.structure.core.Column
import liquibase.structure.datatype.DataType
import liquibase.structure.core.PrimaryKey
import liquibase.structure.core.Table
import liquibase.util.CollectionUtil
import spock.lang.Unroll

class AddAutoIncrementActionTest extends AbstractActionTest {

    @Unroll("#featureName: #tableName.#columnName on #conn")
    def "Can apply standard settings to complex names"() {
        when:
        def action = new AddAutoIncrementAction()
        action.columnName = new Column.ColumnReference((ObjectReference) tableName, columnName.name)
        action.columnDataType = new DataType(DataType.StandardType.INTEGER);

        then:
        runStandardTest([
                columnName_asTable: action.columnName.toString()
        ], action, conn, scope)

        where:
        [conn, scope, tableName, columnName] << connectionSuppliers.collectMany {
            def scope = JUnitScope.getInstance(it)
            return CollectionUtil.permutations([
                    [it],
                    [scope],
                    getObjectNames(Table, ObjectNameStrategy.COMPLEX_NAMES, scope),
                    getObjectNames(Column, ObjectNameStrategy.COMPLEX_NAMES, scope),
            ])
        }

    }

    @Unroll("#featureName: #autoIncrementInformation on #conn")
    def "Valid parameter permutations work"() {
        when:
        def tableName = getObjectNames(Table, ObjectNameStrategy.SIMPLE_NAMES, scope)[0]
        def columnName = getObjectNames(Column, ObjectNameStrategy.SIMPLE_NAMES, scope)[0]
        columnName = new Column.ColumnReference(tableName, columnName.name)

        def action = new AddAutoIncrementAction(new Column.ColumnReference(tableName, columnName.name), new DataType(DataType.StandardType.INTEGER), autoIncrementInformation)

        then:
        runStandardTest([
                columnName_asTable : action.columnName.toString(),
                startWith_asTable  : action.autoIncrementInformation.startWith,
                incrementBy_asTable: action.autoIncrementInformation.incrementBy
        ], action, conn, scope, { plan, result ->
            if (action.autoIncrementInformation.incrementBy != null) { //need to check because checkStatus does not get incrementBy metadata
                assert plan.toString().contains(action.autoIncrementInformation.incrementBy.toString()): "IncrementBy value not used"
            }
            if (action.autoIncrementInformation.startWith != null) { //need to check because checkStatus does not get startWith metadata
                assert plan.toString().contains(action.autoIncrementInformation.startWith.toString()): "StartWith value not used"
            }

        })

        where:
        [conn, scope, autoIncrementInformation] << connectionSuppliers.collectMany {
            def scope = JUnitScope.getInstance(it)
            return CollectionUtil.permutations([
                    [it],
                    [scope],
                    createAllPermutations(Column.AutoIncrementInformation, [
                            startWith  : [null, 1, 2, 10],
                            incrementBy: [null, 1, 5, 20]
                    ]),
            ])
        }

    }

    protected Snapshot createSnapshot(Action action, ConnectionSupplier connectionSupplier, Scope scope) {
        Column.ColumnReference columnName = ((AddAutoIncrementAction) action).columnName
        Snapshot snapshot = new Snapshot(scope)
        snapshot.add(new Table(columnName.relation))
        snapshot.add(new Column(columnName.relation, "id", "int"))
        snapshot.add(new Column(columnName.relation, columnName.name, "int"))

        if (((TestDetails) getTestDetails(scope)).createPrimaryKeyBeforeAutoIncrement()) {
            snapshot.add(new PrimaryKey(null, columnName.container, columnName.name))
        }

        return snapshot
    }

    public static class TestDetails extends AbstractActionTest.TestDetails {
        public boolean createPrimaryKeyBeforeAutoIncrement() {
            return false;
        }
    }
}