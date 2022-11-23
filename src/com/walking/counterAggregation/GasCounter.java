package com.walking.counterAggregation;

public class GasCounter extends Counter {
    public GasCounter() {
        super(NAME, MEASURE_NAME);
    }

    public GasCounter(int startValue) {
        super(NAME, MEASURE_NAME, startValue);
    }

    private static final String NAME = "GasCounter";
    private static final String MEASURE_NAME = "m3";
}
