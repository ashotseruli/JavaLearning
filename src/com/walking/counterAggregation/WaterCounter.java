package com.walking.counterAggregation;

public class WaterCounter extends Counter {

    public WaterCounter() {
        super(NAME, MEASURE_NAME);
    }

    public WaterCounter(int startValue) {
        super(NAME, MEASURE_NAME, startValue);
    }

    private static final String NAME = "WaterCounter";
    private static final String MEASURE_NAME = "m3";
}
