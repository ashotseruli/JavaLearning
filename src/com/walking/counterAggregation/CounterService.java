package com.walking.counterAggregation;

public class CounterService {
    public CounterService(){}

    public CounterService(Counter[] counters){
        this.counters = counters;
    }

    public Counter[] getCounters(){
        return counters; // тут прямо отдаем сцылку на массив и делай с ним что хошь?
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
        if(counter == null){
            // исключение? В остальных методах аналогично
        }
        else {
            newValue = counter.getValue() + diff;
            counter.setValue(newValue);
        }
        return newValue;
    }

    public int increaseCounter(final String name){
        // лучше использовать перегруженный метод или написать метод полностью?
        return increaseCounter(name, 1);
    }

    public void resetCounter(final String name){
        Counter counter = findCounter(name);
        if (counter != null){
            counter.setValue(0);
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
