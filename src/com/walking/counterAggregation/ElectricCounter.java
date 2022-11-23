package com.walking.counterAggregation;

public class ElectricCounter extends Counter {
    public ElectricCounter() {
        super(NAME, MEASURE_NAME);
    }

    public ElectricCounter(int startValue) {
        super(NAME, MEASURE_NAME, startValue);
    }

    private static final String NAME = "ElectricCounter";
    private static final String MEASURE_NAME = "KWth";
}
