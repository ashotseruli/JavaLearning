package com.walking.counterAggregation;

public class Main {
    public static void main(String[] args) {
        CounterService counterService = new CounterService();
        fillCounters(counterService);

        counterService.increaseCounter(GAS_COUNTER_NAME, 10);
        counterService.increaseCounter(WATER_COUNTER_NAME);
        counterService.increaseCounter(ELECTRIC_COUNTER_NAME, 88);

        System.out.println("Gas: " + counterService.getValue(GAS_COUNTER_NAME) + " " + counterService.getMeasureName(GAS_COUNTER_NAME)); // get by name
        System.out.println("Water: " + counterService.getValue(WATER_COUNTER_NAME) + " " + counterService.getMeasureName(WATER_COUNTER_NAME));
        System.out.println("Electricity: " + counterService.getValue(ELECTRIC_COUNTER_NAME) + " " + counterService.getMeasureName(ELECTRIC_COUNTER_NAME));

        System.out.println();

        Counter[] counters = counterService.getCounters(); // надо ли вообще давать такой доступ?
        Counter gasCounter = counters[0];
        gasCounter.reset();
        System.out.println("Gas after reset: " + gasCounter.getValue() + " " + gasCounter.getMeasureName());

        Counter waterCounter = counterService.findCounter(WATER_COUNTER_NAME); // тоже сомнительно насчет корректности доступа
        waterCounter.increase(90);
        System.out.println("Water after increase: " + waterCounter.getValue() + " " + waterCounter.getMeasureName());

        counterService.resetCounter(ELECTRIC_COUNTER_NAME);
        Counter electricCounter = counterService.findCounter(ELECTRIC_COUNTER_NAME);
        System.out.println("Electric after reset: " + electricCounter.getValue() + " " + electricCounter.getMeasureName());

    }


    private static CounterService fillCounters(CounterService counterService) { // по сути бесполезная хрень в текущем контексте применения
        Counter waterCounter = new WaterCounter(1000);
        Counter gasCounter = new GasCounter();
        Counter electricCounter = new ElectricCounter();

        Counter[] counters = counterService.getCounters();
        if (counters.length < 3) {
            //бросаем исключение
        } else {
            counters[0] = gasCounter;
            counters[1] = waterCounter;
            counters[2] = electricCounter;
        }
        return counterService;
    }

    private final static String ELECTRIC_COUNTER_NAME = "ElectricCounter"; // тут бы эти имена все объединить с теми, что в Counter?
    private final static String WATER_COUNTER_NAME = "WaterCounter";
    private final static String GAS_COUNTER_NAME = "GasCounter";
}