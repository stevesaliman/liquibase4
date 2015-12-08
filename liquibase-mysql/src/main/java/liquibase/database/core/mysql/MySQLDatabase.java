package liquibase.database.core.mysql;

import liquibase.database.AbstractJdbcDatabase;
import liquibase.database.DatabaseConnection;
import liquibase.exception.DatabaseException;
import liquibase.structure.LiquibaseObject;
import liquibase.structure.ObjectReference;
import liquibase.structure.core.ForeignKey;
import liquibase.structure.core.Index;
import liquibase.structure.core.Sequence;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MySQLDatabase extends AbstractJdbcDatabase {
    public static final String PRODUCT_NAME = "MySQL";

    private static Set<String> reservedWords = new HashSet();

    public MySQLDatabase() {
        super.setCurrentDateTimeFunction("NOW()");
        // objects in mysql are always case sensitive
        super.quotingStartCharacter = "`";
        super.quotingEndCharacter = "`";
    }


    @Override
    public String getShortName() {
        return "mysql";
    }


    @Override
    protected String getDefaultDatabaseProductName() {
        return "MySQL";
    }

    @Override
    public Integer getDefaultPort() {
        return 3306;
    }

    @Override
    public boolean isCorrectDatabaseImplementation(DatabaseConnection conn) throws DatabaseException {
        return PRODUCT_NAME.equalsIgnoreCase(conn.getDatabaseProductName());
    }

    @Override
    public String getDefaultDriver(String url) {
        if (url.startsWith("jdbc:mysql")) {
            return "com.mysql.jdbc.Driver";
        }
        return null;
    }


    @Override
    public boolean supportsInitiallyDeferrableColumns() {
        return false;
    }

    @Override
    protected boolean mustQuoteObjectName(String objectName, Class<? extends LiquibaseObject> objectType) {
        return super.mustQuoteObjectName(objectName, objectType) || (!objectName.contains("(") && !objectName.matches("\\w+"));
    }

    @Override
    public String getLineComment() {
        return "-- ";
    }

    @Override
    protected String getAutoIncrementClause() {
        return "AUTO_INCREMENT";
    }

    @Override
    protected boolean generateAutoIncrementStartWith(final BigInteger startWith) {
        // startWith not supported here. StartWith has to be set as table option.
        return false;
    }

    public String getTableOptionAutoIncrementStartWithClause(BigInteger startWith) {
        String startWithClause = String.format(getAutoIncrementStartWithClause(), (startWith == null) ? defaultAutoIncrementStartWith : startWith);
        return getAutoIncrementClause() + startWithClause;
    }

    @Override
    protected boolean generateAutoIncrementBy(BigInteger incrementBy) {
        // incrementBy not supported
        return false;
    }

    @Override
    protected String getAutoIncrementOpening() {
        return "";
    }

    @Override
    protected String getAutoIncrementClosing() {
        return "";
    }

    @Override
    protected String getAutoIncrementStartWithClause() {
        return "=%d";
    }

    @Override
    public boolean supportsTablespaces() {
        return false;
    }

    @Override
    public boolean supports(Class<? extends LiquibaseObject> type) {
        return !type.isAssignableFrom(Sequence.class)
                && super.supports(type);
    }

    @Override
    public String escapeObjectName(ObjectReference objectReference) {
        Class<? extends LiquibaseObject> objectType = objectReference.type;
        if (objectType == null) {
            objectType = LiquibaseObject.class;
        }

        if (Index.class.isAssignableFrom(objectType) || ForeignKey.class.isAssignableFrom(objectType)) {
            return super.escapeObjectName(objectReference.name, objectType);
        }
        return super.escapeObjectName(objectReference);
    }

    @Override
    public String escapeString(String string) {
        if (string == null) {
            return null;
        }
        return super.escapeString(string.replace("\\", "\\\\"));
    }

    @Override
    public boolean supportsForeignKeyDisable() {
        return true;
    }

//    @Override
//    public boolean disableForeignKeyChecks() throws DatabaseException {
//        boolean enabled = ExecutorService.getInstance().getExecutor(this).queryForInt(new RawSqlStatement("SELECT @@FOREIGN_KEY_CHECKS")) == 1;
//        ExecutorService.getInstance().getExecutor(this).execute(new RawSqlStatement("SET FOREIGN_KEY_CHECKS=0"));
//        return enabled;
//    }

//    @Override
//    public void enableForeignKeyChecks() throws DatabaseException {
//        ExecutorService.getInstance().getExecutor(this).execute(new RawSqlStatement("SET FOREIGN_KEY_CHECKS=1"));
//    }

    @Override
    public boolean createsIndexesForForeignKeys() {
        return true;
    }

    @Override
    public boolean isReservedWord(String string) {
        if (reservedWords.contains(string.toUpperCase())) {
            return true;
        }
        return super.isReservedWord(string);
    }

    public int getDatabasePatchVersion() throws DatabaseException {
        String databaseProductVersion = this.getDatabaseProductVersion();
        if (databaseProductVersion == null) {
            return 0;
        }

        String versionStrings[] = databaseProductVersion.split("\\.");
        try {
            return Integer.parseInt(versionStrings[2].replaceFirst("\\D.*", ""));
        } catch (IndexOutOfBoundsException e) {
            return 0;
        } catch (NumberFormatException e) {
            return 0;
        }

    }

    {
        //list from http://dev.mysql.com/doc/refman/5.6/en/reserved-words.html
        reservedWords.addAll(Arrays.asList("ACCESSIBLE",
                "ADD",
                "ALL",
                "ALTER",
                "ANALYZE",
                "AND",
                "AS",
                "ASC",
                "ASENSITIVE",
                "BEFORE",
                "BETWEEN",
                "BIGINT",
                "BINARY",
                "BLOB",
                "BOTH",
                "BY",
                "CALL",
                "CASCADE",
                "CASE",
                "CHANGE",
                "CHAR",
                "CHARACTER",
                "CHECK",
                "COLLATE",
                "COLUMN",
                "CONDITION",
                "CONSTRAINT",
                "CONTINUE",
                "CONVERT",
                "CREATE",
                "CROSS",
                "CURRENT_DATE",
                "CURRENT_TIME",
                "CURRENT_TIMESTAMP",
                "CURRENT_USER",
                "CURSOR",
                "DATABASE",
                "DATABASES",
                "DAY_HOUR",
                "DAY_MICROSECOND",
                "DAY_MINUTE",
                "DAY_SECOND",
                "DEC",
                "DECIMAL",
                "DECLARE",
                "DEFAULT",
                "DELAYED",
                "DELETE",
                "DESC",
                "DESCRIBE",
                "DETERMINISTIC",
                "DISTINCT",
                "DISTINCTROW",
                "DIV",
                "DOUBLE",
                "DROP",
                "DUAL",
                "EACH",
                "ELSE",
                "ELSEIF",
                "ENCLOSED",
                "ESCAPED",
                "EXISTS",
                "EXIT",
                "EXPLAIN",
                "FALSE",
                "FETCH",
                "FLOAT",
                "FLOAT4",
                "FLOAT8",
                "FOR",
                "FORCE",
                "FOREIGN",
                "FROM",
                "FULLTEXT",
                "GET",
                "GRANT",
                "GROUP",
                "HAVING",
                "HIGH_PRIORITY",
                "HOUR_MICROSECOND",
                "HOUR_MINUTE",
                "HOUR_SECOND",
                "IF",
                "IGNORE",
                "IN",
                "INDEX",
                "INFILE",
                "INNER",
                "INOUT",
                "INSENSITIVE",
                "INSERT",
                "INT",
                "INT1",
                "INT2",
                "INT3",
                "INT4",
                "INT8",
                "INTEGER",
                "INTERVAL",
                "INTO",
                "IS",
                "ITERATE",
                "JOIN",
                "KEY",
                "KEYS",
                "KILL",
                "LEADING",
                "LEAVE",
                "LEFT",
                "LIKE",
                "LIMIT",
                "LINEAR",
                "LINES",
                "LOAD",
                "LOCALTIME",
                "LOCALTIMESTAMP",
                "LOCK",
                "LONG",
                "LONGBLOB",
                "LONGTEXT",
                "LOOP",
                "LOW_PRIORITY",
                "MASTER_SSL_VERIFY_SERVER_CERT",
                "MATCH",
                "MAXVALUE",
                "MEDIUMBLOB",
                "MEDIUMINT",
                "MEDIUMTEXT",
                "MIDDLEINT",
                "MINUTE_MICROSECOND",
                "MINUTE_SECOND",
                "MOD",
                "MODIFIES",
                "NATURAL",
                "NOT",
                "NO_WRITE_TO_BINLOG",
                "NULL",
                "NUMERIC",
                "ON",
                "OPTIMIZE",
                "OPTION",
                "OPTIONALLY",
                "OR",
                "ORDER",
                "OUT",
                "OUTER",
                "OUTFILE",
                "PARTITION",
                "PRECISION",
                "PRIMARY",
                "PROCEDURE",
                "PURGE",
                "RANGE",
                "READ",
                "READS",
                "READ_WRITE",
                "REAL",
                "REFERENCES",
                "REGEXP",
                "RELEASE",
                "RENAME",
                "REPEAT",
                "REPLACE",
                "REQUIRE",
                "RESIGNAL",
                "RESTRICT",
                "RETURN",
                "REVOKE",
                "RIGHT",
                "RLIKE",
                "SCHEMA",
                "SCHEMAS",
                "SECOND_MICROSECOND",
                "SELECT",
                "SENSITIVE",
                "SEPARATOR",
                "SET",
                "SHOW",
                "SIGNAL",
                "SMALLINT",
                "SPATIAL",
                "SPECIFIC",
                "SQL",
                "SQLEXCEPTION",
                "SQLSTATE",
                "SQLWARNING",
                "SQL_BIG_RESULT",
                "SQL_CALC_FOUND_ROWS",
                "SQL_SMALL_RESULT",
                "SSL",
                "STARTING",
                "STRAIGHT_JOIN",
                "TABLE",
                "TERMINATED",
                "THEN",
                "TINYBLOB",
                "TINYINT",
                "TINYTEXT",
                "TO",
                "TRAILING",
                "TRIGGER",
                "TRUE",
                "UNDO",
                "UNION",
                "UNIQUE",
                "UNLOCK",
                "UNSIGNED",
                "UPDATE",
                "USAGE",
                "USE",
                "USING",
                "UTC_DATE",
                "UTC_TIME",
                "UTC_TIMESTAMP",
                "VALUES",
                "VARBINARY",
                "VARCHAR",
                "VARCHARACTER",
                "VARYING",
                "WHEN",
                "WHERE",
                "WHILE",
                "WITH",
                "WRITE",
                "XOR",
                "YEAR_MONTH",
                "ZEROFILL"));
    }

    @Override
    public boolean requiresDefiningColumnsAsNull() {
        return true;
    }

    @Override
    public boolean metaDataCallsSchemasCatalogs() {
        return true;
    }

    @Override
    public String escapeStringForLike(String string) {
        if (string == null) {
            return null;
        }
        string = string.replace("\\", "\\\\\\\\");
        string = string.replace("'", "''");
        return string;
    }

}
