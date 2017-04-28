package com.oracle.tip.test;

import java.util.ArrayList;

/**
 * Created by vanmoj1 on 9/04/2017.
 */
public class UnitTest {
    static String testID;
    static ArrayList errors = new ArrayList();

    // Override cleanup() if test object
// creation allocates non-memory
// resources that must be cleaned up:
    protected void cleanup() {
    }

    // Verify the truth of a condition:
    protected final void _assert(boolean condition) {
        if (!condition) {
            errors.add("failed: " + testID);
        }
    }
}
