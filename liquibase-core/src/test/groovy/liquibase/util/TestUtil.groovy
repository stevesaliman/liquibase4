package liquibase.util

import java.lang.reflect.Modifier

class TestUtil {

    def static Map<Class, Set<Class>> allClasses

    def static getClasses(Class baseClass) {
        if (allClasses == null) {
            allClasses = [:]
            findAllClasses("liquibase")
        }

        return allClasses.get(baseClass)
    }


    private static findAllClasses(String dirName) {
        def resources = TestUtil.getClassLoader().getResources(dirName)
        while (resources.hasMoreElements()) {
            def url = resources.nextElement()
            def relativeName = url.toExternalForm().replaceFirst(".*/$dirName", dirName)
            def file = new File(url.toURI())
            if (file.isDirectory()) {
                for (File sub : file.listFiles()) {
                    if (sub.isDirectory()) {
                        findAllClasses(relativeName + "/" + sub.name)
                    } else if (sub.name.endsWith(".class")) {
                        if (sub.name.contains('$_$') || sub.name.find(/_closure\d+/)) { // a groovy closure
                            continue;
                        }
                        if (sub.name.contains("Abstract")) {
                            continue;
                        }
                        Class clazz = Class.forName("$relativeName/$sub.name".replace("/", ".").replaceFirst(/\.class$/, ""));

                        if (!isValidClass(clazz)) {
                            continue;
                        }

                        Class superClass = clazz.superclass;
                        Set<Class> interfaces = [] as Set
                        addInterfaces(clazz, interfaces)

                        while (superClass != null && !superClass.equals(Object.class)) {
                            def classList = allClasses.get(superClass)
                            if (classList == null) {
                                classList = [] as Set;
                                allClasses.put(superClass, classList)
                            }
                            allClasses.get(superClass).add(clazz)
                            addInterfaces(superClass, interfaces)

                            superClass = superClass.superclass
                        }

                        for (def iface : interfaces) {
                            def classList = allClasses.get(iface)
                            if (classList == null) {
                                classList = [] as Set;
                                allClasses.put(iface, classList)
                            }
                            classList.add(clazz);
                        }
                    }
                }
            }
        }
    }

    private static addInterfaces(Class<?> clazz, Set<Class> interfaces) {
        def thisInterfaces = clazz.interfaces
        if (thisInterfaces.size() > 0) {
            for (Class iface : thisInterfaces) {
                interfaces.add(iface)
                addInterfaces(iface, interfaces)
            }
        }

    }

    private static isValidClass(Class<?> clazz) {
        if (clazz.isInterface() || Modifier.isAbstract(clazz.getModifiers()) || clazz.isSynthetic() || clazz.isAnonymousClass()) {
            return false;
        }

        return true;
    }

}
