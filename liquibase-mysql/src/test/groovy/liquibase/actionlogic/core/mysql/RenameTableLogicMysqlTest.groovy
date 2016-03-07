package liquibase.actionlogic.core.mysql

import liquibase.actionlogic.AbstractLogicTest

class RenameTableLogicMysqlTest extends AbstractLogicTest {

    @Override
    String getExpectedValidationErrors() {
        return """
RenameTableAction.newName is required
RenameTableAction.newName: cannot rename to a different Schema
RenameTableAction.newName: cannot rename to the same name
RenameTableAction.oldName is required
""".trim()
    }
}
