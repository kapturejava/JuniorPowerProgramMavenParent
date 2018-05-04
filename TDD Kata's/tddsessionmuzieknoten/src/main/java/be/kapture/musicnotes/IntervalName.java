package be.kapture.musicnotes;

import java.util.Arrays;

public enum IntervalName {
    PRIME(0), SECUNDE(1), TERTS(2), KWART(3), KWINT(4), SEXT(5), SEPTIEM(6), OCTAAF(7);

    private int intervalDistance;

    IntervalName(int intervalDistance) {
        this.intervalDistance = intervalDistance;
    }

    static IntervalName getIntervalName(int distance){
        return Arrays.stream(values())
                .filter(ik -> ik.intervalDistance == distance)
                .findAny()
                .orElseThrow(IllegalAccessError::new);
    }

}
