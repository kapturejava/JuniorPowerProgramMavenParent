package com.oracle.innerclasses;

/**
 * Created by vanmoj1 on 6/04/2017.
 */
public class DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }

    public class Inner {
        public DotThis outer() {
            return DotThis.this;
        }
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();

        DotThis.Inner dni = dt.new Inner();
        dni.outer().f();
    }
}
