package com.github.speisz.euler.problem._0._2._1;

import java.util.AbstractMap;
import java.util.Map;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;
import static java.util.stream.IntStream.rangeClosed;

public class AmicableNumberFinder {
    private static final ToIntFunction<Integer> IDENTITY = n -> n;

    public static AmicableNumberFinder create() {
        return new AmicableNumberFinder();
    }

    public IntStream streamUpTo(int upperBound) {
        Map<Integer, Integer> numberToProperDivisorCount = rangeClosed(1, upperBound)
                .mapToObj(n -> new AbstractMap.SimpleEntry<>(n, ProperDivisors.of(n).stream().mapToInt(IDENTITY).sum()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));

        return numberToProperDivisorCount.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(entry.getValue()))
                .filter(entry -> numberToProperDivisorCount.containsKey(entry.getValue()) && numberToProperDivisorCount.get(entry.getValue()).equals(entry.getKey()))
                .mapToInt(Map.Entry::getKey);
    }

    private AmicableNumberFinder() {
    }
}
