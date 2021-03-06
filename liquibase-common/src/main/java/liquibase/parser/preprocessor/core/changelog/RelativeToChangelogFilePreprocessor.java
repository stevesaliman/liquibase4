package liquibase.parser.preprocessor.core.changelog;

import liquibase.Scope;
import liquibase.exception.LiquibaseException;
import liquibase.exception.ParseException;
import liquibase.parser.ParsedNode;
import liquibase.parser.preprocessor.AbstractParsedNodePreprocessor;

import java.util.SortedSet;

/**
 * Preprocessor that finds "relativeToChangeLog" nodes and adjusts the "path" sibling element to be an absolute path based on the location of the changelog file.
 */
public class RelativeToChangelogFilePreprocessor extends AbstractParsedNodePreprocessor {

    @Override
    public void process(ParsedNode node, Scope scope) throws ParseException {
        for (ParsedNode relativeToChangelogFile : node.getChildren("relativeToChangelogFile", true)) {
            if (relativeToChangelogFile.getValue(false, Boolean.class)) {
                ParsedNode parent = relativeToChangelogFile.getParent();
                ParsedNode path = parent.getChild("path", false);
                if (path == null || path.getValue() == null) {
                    throw new ParseException("No 'path' element for 'relativeToChangeLog' to use", parent);
                }
                try {
                    SortedSet<String> files = scope.getResourceAccessor().list(path.getValue(null, String.class), parent.fileName, false);
                    if (files == null || files.size() == 0) {
                        throw new ParseException("Could not find a file '"+path.getValue()+"' relative to '"+parent.fileName+"'", parent);
                    } else if (files.size() > 0) {
                        throw new ParseException("Found "+files.size()+" files that match '"+path.getValue()+"' relative to '"+parent.fileName+"'", parent);
                    } else {
                        path.setValue(files.iterator().next());
                    }
                } catch (LiquibaseException e) {
                    throw new ParseException(e, parent);
                }
            }
            relativeToChangelogFile.remove();
        }
    }
}
