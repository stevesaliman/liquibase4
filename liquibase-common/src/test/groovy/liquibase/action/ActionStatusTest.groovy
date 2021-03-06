package liquibase.action

import liquibase.AbstractExtensibleObject
import spock.lang.Specification
import spock.lang.Unroll

class ActionStatusTest extends Specification {

    @Unroll
    def "status logic works correctly"() {
        expect:
        status.toString() == expected

        where:
        status                                                                                         | expected
        new ActionStatus()                                                                             | "Unknown: no assertions made"
        new ActionStatus().assertCorrect(true, "Don't show")                                           | "Applied"
        new ActionStatus().assertApplied(true, "Don't show")                                           | "Applied"
        new ActionStatus().assertApplied(true, "Don't show")                                           | "Applied"
        new ActionStatus().assertApplied(false, "Applied Error")                                       | "Not Applied: Applied Error"
        new ActionStatus().add(ActionStatus.Status.unknown, "An error")                                                         | "Unknown: An error"
        new ActionStatus().unknown(new RuntimeException("Exception message"))                          | "Unknown: Exception message (java.lang.RuntimeException)"
        new ActionStatus().assertApplied(false, "Applied Error").assertApplied(false, "Another error") | "Not Applied: Another error, Applied Error"
        new ActionStatus().assertCorrect(false, "Correct Error")                                       | "Incorrect: Correct Error"
        new ActionStatus().assertCorrect(false, "Correct Error").assertApplied(false, "Applied Error") | "Not Applied: Applied Error"
        new ActionStatus().assertCorrect(false, "Correct Error").assertApplied(false, "Applied Error") | "Not Applied: Applied Error"
        new ActionStatus().add(ActionStatus.Status.unknown, "Something wrong").assertApplied(false, "Applied Error")            | "Unknown: Something wrong"
    }

    @Unroll
    def "assertCorrect using parameterName"() {
        when:
        def object1 = new AbstractExtensibleObject()
        def object2 = new AbstractExtensibleObject()
        object1.set(propertyName, object1Value)
        object2.set(propertyName, object2Value)

        then:
        new ActionStatus().assertPropertyCorrect(object1, object2, propertyName).toString() == expected

        where:
        propertyName | object1Value | object2Value | expected
        "prop"       | "a"          | "a"          | "Applied"
        "prop"       | "a"          | "b"          | "Incorrect: 'prop' is incorrect on AbstractExtensibleObject{prop=b} (expected 'a' got 'b')"
        "prop"       | "a"          | null         | "Incorrect: 'prop' is incorrect on AbstractExtensibleObject{} (expected 'a' got 'null')"
        "prop"       | null         | "a"          | "Incorrect: 'prop' is incorrect on AbstractExtensibleObject{prop=a} (expected 'null' got 'a')"
        "prop"       | null         | null         | "Applied"

    }
}
