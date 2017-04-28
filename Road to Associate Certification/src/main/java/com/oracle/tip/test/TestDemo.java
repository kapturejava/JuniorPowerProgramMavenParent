package com.oracle.tip.test;

/**
 * Created by vanmoj1 on 9/04/2017.
 */
public class TestDemo {
    private static int objCounter = 0;
    private int id = ++objCounter;

    public TestDemo(String s) {
        System.out.println(s + ": count = " + id);
    }

    public void close() {
        System.out.println("Cleaning up: " + id);
    }

    public boolean someCondition() {
        return true;
    }

    public static class Test extends UnitTest {
        TestDemo test1 = new TestDemo("test1");
        TestDemo test2 = new TestDemo("test2");

        public void cleanup() {
            test2.close();
            test1.close();
        }

        public void testA() {
            System.out.println("TestDemo.testA");
            _assert(test1.someCondition());
        }

        public void testB() {
            System.out.println("TestDemo.testB");
            _assert(test2.someCondition());
            _assert(TestDemo.objCounter != 0);
        }

        // Causes the build to halt:
//        public void test3() {
//            _assert(false);
//        }
    }
}
