package liquibase.database.core.h2;

import liquibase.Scope;
import liquibase.database.AbstractJdbcDatabase;
import liquibase.database.DatabaseConnection;
import liquibase.item.FunctionCall;
import liquibase.item.Item;
import liquibase.item.core.StoredProcedure;

import java.util.Arrays;

public class H2Database extends AbstractJdbcDatabase {

    public H2Database() {
        this.currentDateTimeFunction = new FunctionCall("NOW()");

        this.reservedWords.addAll(Arrays.asList(
                "LIMIT",
                "MINUS",
                "ROWNUM",
                "SYSDATE",
                "SYSTIME",
                "SYSTIMESTAMP",
                "TODAY",
                "WHERE"
        ));
    }

    @Override
    public String getShortName() {
        return "h2";
    }

    @Override
    public boolean supports(DatabaseConnection conn, Scope scope) {
        return "H2".equals(conn.getDatabaseProductName());
    }

    @Override
    protected int getMaxObjectPathLength(Class<? extends Item> objectType, Scope scope) {
        int length = super.getMaxObjectPathLength(objectType, scope);
        if (length > 2) { //Can only return up to object + schema
            return 2;
        } else {
            return length;
        }
    }

    @Override
    public boolean supports(Class<? extends Item> type, Scope scope) {
        if (StoredProcedure.class.isAssignableFrom(type)) {
            return false;
        }
        return super.supports(type, scope);
    }

    @Override
    public boolean supports(Feature feature, Scope scope) {
        switch (feature) {
            case AUTO_CREATES_INDEXES_FOR_FOREIGN_KEYS:
                return true;
        }
        return super.supports(feature, scope);
    }
}
