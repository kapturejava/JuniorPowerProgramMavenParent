package com.oracle.tip.test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;

/**
 * Created by vanmoj1 on 9/04/2017.
 */
public class RunUnitTests {
    public static void require(boolean requirement, String errmsg) {
        if (!requirement) {
            System.err.println(errmsg);
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        require(args.length == 1, "Usage: RunUnitTests qualified-class");
        try {
            Class c = Class.forName(args[0]);
            Class[] classes = c.getDeclaredClasses();
            Class ut = null;
            for (int j = 0; j < classes.length; j++) {
                if (!UnitTest.class.isAssignableFrom(classes[j])) {
                    continue;
                }
                ut = classes[j];
                break;
            }
            if (ut != null) {
                require(Modifier.isStatic(ut.getModifiers()), "inner UnitTest class must be static");
            }
            if (ut == null) {
                if (UnitTest.class.isAssignableFrom(c)) {
                    ut = c;
                }
            }
            require(ut != null, "No UnitTest class found");
            require(Modifier.isPublic(ut.getModifiers()), "UnitTest class must be public");
            Method[] methods = ut.getMethods();
            for (int k = 0; k < methods.length; k++) {
                Method m = methods[k];
                if (m.getName().equals("cleanup")) {
                    continue;
                }
                if (m.getParameterTypes().length == 0 && m.getReturnType() == void.class && Modifier.isPublic(m.getModifiers())) {
                    UnitTest.testID = m.getName();
                    Object test = ut.newInstance();
                    m.invoke(test, new Object[0]);
                    ((UnitTest) test).cleanup();
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
        if (UnitTest.errors.size() != 0) {
            Iterator it = UnitTest.errors.iterator();
            while (it.hasNext()) {
                System.err.println(it.next());
            }
            System.exit(1);
        }
    }
}
