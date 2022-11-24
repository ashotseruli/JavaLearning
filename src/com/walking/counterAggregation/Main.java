package com.walking.counterAggregation;

public class Main {
    public static void main(String[] args) {
        counterService = new CounterService();

        // создаем счетчики и грубо заполняем массив. Хрень же?
        counterService.getCounters()[0] = new Counter(GAS_COUNTER_NAME, CUBIC_METER);
        counterService.getCounters()[1] = new Counter(COLD_WATER_COUNTER_NAME, CUBIC_METER, 200);
        counterService.getCounters()[2] = new Counter(HOT_WATER_COUNTER_NAME, CUBIC_METER, 68);
        counterService.getCounters()[3] = new Counter(ELECTRIC_COUNTER_NAME, KILOWATT_HOUR, 300);

        showCounters();
        System.out.println();

        // дальше просто всячески используем
        counterService.increaseCounter(GAS_COUNTER_NAME, 10);
        counterService.resetCounter(COLD_WATER_COUNTER_NAME);
        counterService.increaseCounter(HOT_WATER_COUNTER_NAME, -56);
        counterService.increaseCounter(ELECTRIC_COUNTER_NAME, 88);

        showCounters();
        System.out.println();

        Counter[] counters = counterService.getCounters(); // надо ли вообще давать такой доступ?
        Counter gasCounter = counters[0];
        gasCounter.setValue(0);
        System.out.println(gasCounter.getName() + " after reset: " + gasCounter.getValue() + " " + gasCounter.getMeasureName());

        Counter coldWaterCounter = counterService.findCounter(COLD_WATER_COUNTER_NAME); // тоже сомнительно насчет корректности доступа
        counterService.increaseCounter(COLD_WATER_COUNTER_NAME, 90);
        System.out.println(coldWaterCounter.getName() + " after increase: " + coldWaterCounter.getValue() + " " + coldWaterCounter.getMeasureName()); // тут выводим через сам счетчик

        counterService.resetCounter(ELECTRIC_COUNTER_NAME);
        System.out.println( counterService.findCounter(ELECTRIC_COUNTER_NAME).getName() + " after reset: " +
                            counterService.findCounter(ELECTRIC_COUNTER_NAME).getValue() + " " +
                            counterService.findCounter(ELECTRIC_COUNTER_NAME).getMeasureName());

        System.out.println( counterService.findCounter(HOT_WATER_COUNTER_NAME).getName() + " after increase: " +
                            counterService.increaseCounter(HOT_WATER_COUNTER_NAME) + " " +
                            counterService.getMeasureName(HOT_WATER_COUNTER_NAME));

        System.out.println("GAS counter: " + counterService.getValue(GAS_COUNTER_NAME) + counterService.getMeasureName(GAS_COUNTER_NAME));

    }

    private static CounterService counterService;
    private static void showCounters(){
        Counter[] counters = counterService.getCounters();
        for(Counter c:counters){
            System.out.println(c.getName() + ": " + c.getValue() + " " + c.getMeasureName());
        }
    }
    private final static String ELECTRIC_COUNTER_NAME = "Electricity"; // тут бы эти имена все объединить с теми, что в Counter?
    private final static String COLD_WATER_COUNTER_NAME = "Cold water";
    private final static String HOT_WATER_COUNTER_NAME = "Hot water";
    private final static String GAS_COUNTER_NAME = "Gas";

    private final static String CUBIC_METER = "m3";
    private final static String KILOWATT_HOUR = "KWt*h";
}