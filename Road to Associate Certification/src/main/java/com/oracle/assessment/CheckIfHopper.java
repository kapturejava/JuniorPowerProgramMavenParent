package com.oracle.assessment;

/**
 * Created by vanmoj1 on 11/04/2017.
 */
public class CheckIfHopper implements CheckTrait {
    @Override
    public boolean test(Animal a) {
        return a.isCanHop();
    }
}
