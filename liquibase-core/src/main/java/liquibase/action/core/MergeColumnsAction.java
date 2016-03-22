package liquibase.action.core;

import liquibase.action.AbstractAction;
import liquibase.item.core.RelationReference;
import liquibase.item.datatype.DataType;

/**
 * Combines two existing columns into a new column.
 * Values for each row are inserted with {@link #joinString} between {@link #column1Name} and {@link #column2Name}
 * The old column1 and column2 are dropped a part of this action.
 */
public class MergeColumnsAction extends AbstractAction {

    public RelationReference relation;

    public String column1Name;

    /**
     * String to use joining column1Name and column2Name. Standard default value is a single space.
     */
    public String joinString;
    public String column2Name;

    public String finalColumnName;
    public DataType finalColumnType;

}