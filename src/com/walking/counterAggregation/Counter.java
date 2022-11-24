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

    public int getValue() {
        return value;
    }

    public void setValue(int value){
        if (value < 0){
            System.out.println("sub zero value!");
            //throw exception?
        }
        this.value = value;
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
