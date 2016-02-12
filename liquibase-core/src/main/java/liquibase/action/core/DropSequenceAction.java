package liquibase.action.core;

import liquibase.action.AbstractAction;
import liquibase.structure.ObjectReference;

/**
 * Action to drop an existing sequence.
 */
public class DropSequenceAction extends AbstractAction {

    public ObjectReference sequence;

    public DropSequenceAction(ObjectReference sequence) {
        this.sequence = sequence;
    }

    public DropSequenceAction() {


    }
}
