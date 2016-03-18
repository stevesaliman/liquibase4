package liquibase.actionlogic.core.mysql

import liquibase.actionlogic.AbstractActionLogicTest

class CreateTableLogicMysqlTest extends AbstractActionLogicTest {

    @Override
    String getExpectedValidationErrors() {
        return """
CreateTableAction.columns is required
CreateTableAction.columns.name is required
CreateTableAction.columns.type is required
CreateTableAction.columns: auto-increment columns must be primary keys
CreateTableAction.columns: cannot add a multi-column primary key and mark a column as auto-increment
CreateTableAction.columns: cannot set both a default value and auto-increment
CreateTableAction.columns: primary key columns cannot be nullable
CreateTableAction.foreignKeys.columnChecks is required
CreateTableAction.foreignKeys.initiallyDeferred is not supported
CreateTableAction.foreignKeys.referencedTable is required
CreateTableAction.foreignKeys.relation is required
CreateTableAction.primaryKey.clustered: not supported
CreateTableAction.primaryKey.columns is required
CreateTableAction.primaryKey.columns: 'DESC'
CreateTableAction.primaryKey.relation is required
CreateTableAction.primaryKey.tablespace is not supported
CreateTableAction.table is required
CreateTableAction.table.name is required
CreateTableAction.table.tablespace is not supported
CreateTableAction.uniqueConstraints.columns is required
CreateTableAction.uniqueConstraints.deferrable is not supported
CreateTableAction.uniqueConstraints.disabled is not supported
CreateTableAction.uniqueConstraints.initiallyDeferred is not supported
CreateTableAction.uniqueConstraints.relation is required
CreateTableAction.uniqueConstraints.tablespace is not supported
CreateTableAction: Step error: AlterRemarksAction.object.type: only supports tables
CreateTableAction: a nullable auto-increment column is not supported
CreateTableAction: delete rule SET DEFAULT is not supported
CreateTableAction: update rule SET DEFAULT is not supported
""".trim()
    }
}
