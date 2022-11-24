package com.walking.counterAggregation;

public class Main {
    public static void main(String[] args) {
        CounterService counterService = new CounterService();

        // создаем счетчики и грубо заполняем массив
        counterService.getCounters()[0] = new Counter(GAS_COUNTER_NAME, CUBIC_METER, 1000);
        counterService.getCounters()[1] = new Counter(WATER_COUNTER_NAME, CUBIC_METER, 200);
        counterService.getCounters()[2] = new Counter(ELECTRIC_COUNTER_NAME, KILOWATT_HOUR, 300);

        // дальше просто всячески используем
        counterService.increaseCounter(GAS_COUNTER_NAME, 10);
        counterService.increaseCounter(WATER_COUNTER_NAME);
        counterService.increaseCounter(ELECTRIC_COUNTER_NAME, 88);

        System.out.println("Gas: " + counterService.getValue(GAS_COUNTER_NAME) + " " + counterService.getMeasureName(GAS_COUNTER_NAME)); // get by name
        System.out.println("Water: " + counterService.getValue(WATER_COUNTER_NAME) + " " + counterService.getMeasureName(WATER_COUNTER_NAME));
        System.out.println("Electricity: " + counterService.getValue(ELECTRIC_COUNTER_NAME) + " " + counterService.getMeasureName(ELECTRIC_COUNTER_NAME));

        System.out.println();

        Counter[] counters = counterService.getCounters(); // надо ли вообще давать такой доступ?
        Counter gasCounter = counters[0];
        gasCounter.setValue(0);
        System.out.println("Gas after reset: " + gasCounter.getValue() + " " + gasCounter.getMeasureName());

        Counter waterCounter = counterService.findCounter(WATER_COUNTER_NAME); // тоже сомнительно насчет корректности доступа
        counterService.increaseCounter(WATER_COUNTER_NAME, 90);
        System.out.println("Water after increase: " + waterCounter.getValue() + " " + waterCounter.getMeasureName()); // тут выводим через сам счетчик

        counterService.resetCounter(ELECTRIC_COUNTER_NAME);
        System.out.println("Electric after reset: " + counterService.getValue(ELECTRIC_COUNTER_NAME) + " " + counterService.getMeasureName(ELECTRIC_COUNTER_NAME));

    }
    private final static String ELECTRIC_COUNTER_NAME = "ElectricCounter"; // тут бы эти имена все объединить с теми, что в Counter?
    private final static String WATER_COUNTER_NAME = "WaterCounter";
    private final static String GAS_COUNTER_NAME = "GasCounter";

    private final static String CUBIC_METER = "m3";
    private final static String KILOWATT_HOUR = "KWt*h";
}