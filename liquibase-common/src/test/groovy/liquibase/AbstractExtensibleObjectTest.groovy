package liquibase

import liquibase.action.core.AddAutoIncrementAction
import liquibase.action.core.CreateTableAction
import liquibase.action.core.DropTablesAction
import liquibase.item.ItemReference
import liquibase.item.core.*
import spock.lang.Specification

import static org.hamcrest.Matchers.containsInAnyOrder
import static spock.util.matcher.HamcrestSupport.that

class AbstractExtensibleObjectTest extends Specification {

    def "getAttributeNames"() {
        when:
        def nonFieldObject = new AbstractExtensibleObject() {};
        nonFieldObject.set("value1", "One")
        nonFieldObject.set("value2", "Two")
        nonFieldObject.set("value3", 3)
        nonFieldObject.set("valueNull", null)

        def fieldObject = new AddAutoIncrementAction();
        fieldObject.set("value1", "One")
        fieldObject.set("value2", 2)
        fieldObject.set("startWith", 12)
        fieldObject.autoIncrementInformation = new Column.AutoIncrementInformation(null, new BigInteger(32))
        fieldObject.column = new ColumnReference("x", "y")

        then:
        that nonFieldObject.getAttributes(), containsInAnyOrder(["value1", "value2", "value3"] as String[])
        that fieldObject.getAttributes(), containsInAnyOrder(["value1", "value2", "startWith", "autoIncrementInformation", "column"] as String[])
    }

    def "getObjectMetaData attributes are created for standard attributes"() {
        expect:
        that new AddAutoIncrementAction().getObjectMetaData().attributes*.name, containsInAnyOrder(["dataType", "column", "autoIncrementInformation"] as String[])
        that new AddAutoIncrementAction().getObjectMetaData().attributes*.name, containsInAnyOrder(["dataType", "column", "autoIncrementInformation"] as String[]) //caching works

        that new DropTablesAction().getObjectMetaData().attributes*.name, containsInAnyOrder(["tables", "cascadeConstraints"] as String[])

        (new AbstractExtensibleObject() {}).getObjectMetaData().attributes.size() == 0
    }

    def "get/set works with non-field values"() {
        when:
        def obj = new AbstractExtensibleObject() {};
        obj.set("value1", "One")
        obj.set("value2", "Two")
        obj.set("value3", 3)
        obj.set("valueNull", null)

        then:
        obj.get("value1", String) == "One"
        obj.get("value2", String) == "Two"
        obj.get("value3", String) == "3"
        obj.get("value3", Integer) == 3
        obj.get("valueNull", Integer) == null
        obj.get("valueUndefined", Integer) == null
    }

    def "get/set works with field values"() {
        when:
        def obj = new AddAutoIncrementAction();
        obj.set("value1", "One")
        obj.set("value2", 2)
        obj.autoIncrementInformation = new Column.AutoIncrementInformation(null, new BigInteger(32))
        obj.autoIncrementInformation.set("startWith", 12)

        then:
        obj.get("value1", String) == "One"
        obj.get("value2", String) == "2"
        obj.get("value2", Integer) == 2

        obj.autoIncrementInformation.get("startWith", Integer) == 12
        obj.autoIncrementInformation.get("startWith", String) == "12"
        obj.autoIncrementInformation.startWith == new BigInteger("12")
        assert obj.autoIncrementInformation.has("startWith")

        obj.autoIncrementInformation.get("incrementBy", Integer) == 32
        obj.autoIncrementInformation.get("incrementBy", String) == "32"
        obj.autoIncrementInformation.incrementBy == new BigInteger("32")
        assert obj.autoIncrementInformation.has("incrementBy")

        obj.dataType == null;
        obj.get("dataType", String) == null
        assert !obj.has("dataType")
    }

    def "get/set works with field values on parent objects"() {
        when:
        def obj = new Table();
        obj.set("value1", "One")
        obj.set("value2", 2)
        obj.name = "testTable"
        obj.tablespace = "test_tablespace"

        then:
        obj.get("value2", String) == "2"
        obj.tablespace == "test_tablespace"
        obj.name == "testTable"
        obj.get("name", String) == "testTable"

        when:
        obj.set("tablespace", "other_tablespace")
        obj.set("name", "newTableName")

        then:
        obj.get("value2", String) == "2"
        obj.tablespace == "other_tablespace"
        obj.name.toString() == "newTableName"
        obj.get("name", String) == "newTableName"
    }

    def "nested properties work"() {
        when:
        def obj = new CreateTableAction()
        obj.table = new Table("test_table", new SchemaReference("schema_name"))
        obj.uniqueConstraints = [new UniqueConstraint(null, new RelationReference(Table, "test_table"), "col1a", "col1b"), new UniqueConstraint(null, new RelationReference(Table, "test_table"), "col2")]
        obj.foreignKeys = [
                new ForeignKey("fk1", new RelationReference(Table, "base_table1"), new RelationReference(Table, "ref_table1"), ["base_1"], ["ref_1"]),
                new ForeignKey("fk2", new RelationReference(Table, "base_table2"), new RelationReference(Table, "ref_table2"), ["base_2a", "base_2b"], ["ref_2a", "ref_2b"]),
        ]

        then:
        obj.get("table.name", String.class) == "test_table"
        obj.get("table.schema.name", String.class) == "schema_name"
        obj.get("table.schema.container", ItemReference.class) == null
        obj.get("table.primaryKey.tablespace", String.class) == null //nulls in the chain return null
        obj.get("uniqueConstraints.name", List) == [null, null]
        obj.get("uniqueConstraints.columns", List) == ["col1a", "col1b", "col2"]
        obj.get("foreignKeys.name", List) == ["fk1", "fk2"]
        obj.get("foreignKeys.relation", List) == [new RelationReference(Table, "base_table1"), new RelationReference(Table, "base_table2")]
        obj.get("foreignKeys.columnChecks.baseColumn", List) == ["base_1", "base_2a", "base_2b"]
        obj.get("foreignKeys.columnChecks.referencedColumn", List) == ["ref_1", "ref_2a", "ref_2b"]

    }

    def "collections with only null values count as null"() {
        when:
        def obj = new AbstractExtensibleObject([
                a: "a",
                b: ["b"],
                c: [null],
                d: [null, null],
                e: [new AbstractExtensibleObject()],
        ])

        then:
        obj.get("a", Object) == "a"
        obj.get("b", Object) == ["b"]
        obj.get("c", Object) == [null]
        obj.get("d", Object) == [null, null]
        obj.get("e.x", Object) == [null]
        obj.get("e.x.y", Object) == null

    }
}