package liquibase.action.core;

import liquibase.Scope;
import liquibase.action.AbstractAction;
import liquibase.exception.ParseException;
import liquibase.parser.ParsedNode;
import liquibase.parser.preprocessor.ParsedNodePreprocessor;
import liquibase.parser.preprocessor.core.changelog.AbstractActionPreprocessor;

/**
 * Throws an exception when executed.
 */
public class ThrowExceptionAction extends AbstractAction {

    public Throwable exception;

    public ThrowExceptionAction() {
    }

    /**
     * Creates a {@link liquibase.action.core.ThrowExceptionAction.ThrowExceptionActionException} with the given message.
     */
    public ThrowExceptionAction(String message) {
        this.exception = new ThrowExceptionActionException(message);
    }

    public ThrowExceptionAction(Throwable exception) {
        this.exception = exception;
    }


    @Override
    public ParsedNodePreprocessor createPreprocessor() {
        return new AbstractActionPreprocessor(ThrowExceptionAction.class) {

            @Override
            protected String[] getAliases() {
                return new String[]{"stop"};
            }

            @Override
            protected void processActionNode(ParsedNode actionNode, Scope scope) throws ParseException {
                if (actionNode.getValue() != null) {
                    actionNode.moveValue(actionNode.addChild("message"));
                }

                ParsedNode message = actionNode.getChild("message", false);
                if (message != null) {
                    message.setValue(new ThrowExceptionActionException(message.getValue(null, String.class)));
                    message.rename("exception");
                }
            }
        };
    }

    public static class ThrowExceptionActionException extends RuntimeException {

        public ThrowExceptionActionException() {
        }

        public ThrowExceptionActionException(String message) {
            super(message);
        }

        public ThrowExceptionActionException(String message, Throwable cause) {
            super(message, cause);
        }

        public ThrowExceptionActionException(Throwable cause) {
            super(cause);
        }
    }
}
