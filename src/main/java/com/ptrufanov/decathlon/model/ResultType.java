package com.ptrufanov.decathlon.model;

import java.util.function.Function;
import java.util.regex.Pattern;

import static com.ptrufanov.decathlon.model.EventType.*;

public enum ResultType {

    RUN_100_M(25.4347, 18, 1.81, TRACK, Converters.metresConverter()),
    LONG_JUMP(0.14354, 220, 1.4, FIELD, Converters.centimetresConverter()),
    SHOT_PUT(51.39, 1.5, 1.05, FIELD, Converters.metresConverter()),
    HIGH_JUMP(0.8465, 75, 1.42, FIELD, Converters.centimetresConverter()),
    RUN_400_M(1.53775, 82, 1.81, TRACK, Converters.metresConverter()),
    RUN_110_M_HURDLES(5.74352, 28.5, 1.92, TRACK, Converters.metresConverter()),
    DISCUS_THROW(12.91, 4, 1.1, FIELD, Converters.metresConverter()),
    POLE_VAULT(0.2797, 100, 1.35, FIELD, Converters.centimetresConverter()),
    JAVELIN_THROW(10.14, 7, 1.08, FIELD, Converters.metresConverter()),
    RUN_1500_M(0.03768, 480, 1.85, TRACK, Converters.minutesToSecondsConverter());

    private final double parameterA;
    private final double parameterB;
    private final double parameterC;
    private final EventType eventType;
    private final Function<String, Double> converter;

    ResultType(double parameterA, double parameterB, double parameterC, EventType eventType, Function<String, Double> converter) {
        this.parameterA = parameterA;
        this.parameterB = parameterB;
        this.parameterC = parameterC;
        this.eventType = eventType;
        this.converter = converter;
    }

    public double getParameterA() {
        return parameterA;
    }

    public double getParameterB() {
        return parameterB;
    }

    public double getParameterC() {
        return parameterC;
    }

    public EventType getEventType() {
        return eventType;
    }

    public Function<String, Double> getConverter() {
        return converter;
    }

    private static class Converters {
        public static Function<String, Double> metresConverter() {
            return Double::parseDouble;
        }

        public static Function<String, Double> centimetresConverter() {
            return time -> Double.parseDouble(time) * 100;
        }

        public static Function<String, Double> minutesToSecondsConverter() {
            return time -> {
                if (Pattern.matches("^\\d+:[0-5]\\d.[0-9]\\d$", time)) {
                    String[] array = time.split(":");
                    int minutes = Integer.parseInt(array[0]);
                    double seconds = Double.parseDouble(array[1]);
                    return minutes * 60 + seconds;
                } else {
                    throw new RuntimeException("Wrong time format " + time);
                }
            };
        }
    }
}
