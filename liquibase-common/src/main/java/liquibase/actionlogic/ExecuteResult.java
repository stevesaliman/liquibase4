package liquibase.actionlogic;

import liquibase.action.Action;
import liquibase.util.StringUtil;

/**
 * Result for a generic action which isn't a query, update or rewrite.
 */
public class ExecuteResult extends ActionResult {

    public ExecuteResult(Action sourceAction) {
        super(sourceAction);
    }

    public ExecuteResult(Action sourceAction, String message) {
        super(sourceAction, message);
    }

    @Override
    public String toString() {
        return "Executed: "+ StringUtil.defaultIfEmpty(getMessage(), "No Message");
    }
}
