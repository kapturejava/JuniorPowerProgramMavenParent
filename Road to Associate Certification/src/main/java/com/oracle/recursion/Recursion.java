package com.oracle.recursion;

import java.util.Arrays;

/**
 * Created by vanmoj1 on 5/04/2017.
 */
public class Recursion {
    public int sum(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        if (numbers.length == 1) {
            return numbers[0];
        } else {
            return numbers[0] + sum(Arrays.copyOfRange(numbers, 1, numbers.length));
        }
    }

    /**
     *
     * Tail Recursion -> No support yet in JVM JIT
     *
     * @param initial
     * @param numbers
     * @return
     */
    public int sum(int initial, int[] numbers) {
        if (numbers.length == 0) {
            return initial;
        }
        if (numbers.length == 1) {
            return initial + numbers[0];
        } else {
            return sum(initial + numbers[0],
                    Arrays.copyOfRange(numbers, 1, numbers.length));
        }
    }
}
