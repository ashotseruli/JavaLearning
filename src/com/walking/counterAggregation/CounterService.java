package com.walking.counterAggregation;

public class CounterService {
    public CounterService(){
        counters[0] = new GasCounter();
        counters[1] = new WaterCounter();
        counters[2] = new ElectricCounter();
    }

    public CounterService(Counter[] counters){
        this.counters = counters;
    }

    public Counter[] getCounters(){
        return counters; // тут точно так должно быть?
    }

    public Counter findCounter(final String name){
        Counter found = null;
        for(Counter c:counters){
            if (c.getName().equals(name)){
                found = c;
                break;
            }
        }
        return found;
    }

    public int increaseCounter(final String name, int diff){
        int newValue = 0;
        Counter counter = findCounter(name);
        if (counter != null){
            newValue = counter.increase(diff);
        }
        return newValue;
    }

    public int increaseCounter(final String name){
        int newValue = 0;
        Counter counter = findCounter(name);
        if (counter != null){
            newValue = counter.increase();
        }
        return newValue;
    }

    public void resetCounter(final String name){
        Counter counter = findCounter(name);
        if (counter != null){
            counter.reset();
        }
    }

    public String getMeasureName(final String name){
        String measureName = null;
        Counter counter = findCounter(name);
        if (counter != null){
            measureName = counter.getMeasureName();
        }
        return measureName;
    }

    public int getValue(final String name){
        int value = 0;
        Counter counter = findCounter(name);
        if (counter != null){
            value = counter.getValue();
        }
        return value;
    }

    private Counter[] counters = new Counter[3]; // тут, конечно, должна быть коллекция
}
