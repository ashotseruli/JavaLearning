package com.walking.counterAggregation;

public class Counter {
    public Counter(String name, String measureName) {
        this.name = name;
        this.measureName = measureName;
        this.value = 0;
    }

    public Counter(String name, String measureName, int startValue) {
        this.name = name;
        this.measureName = measureName;
        this.value = startValue;
    }

    public int increase(int diff) {
        if (diff < 0) {
            System.out.println("Rolling down the counter!");
        }
        value += diff;
        return value;
    }

    public int increase() {
        return ++value;
    }

    public void reset() {
        value = 0;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getMeasureName() {
        return measureName;
    }

    private final String measureName;
    private final String name;
    private int value;
}
