package com.github.speisz.euler.problem._0._1._0;

import java.util.function.IntPredicate;

import static java.util.stream.IntStream.rangeClosed;

public class StreamSum {
    public long get(int upperBound, IntPredicate condition) {
        return rangeClosed(1, upperBound)
                .filter(condition)
                .mapToLong(n -> n)
                .sum();
    }

    public long get(int upperBound) {
        return get(upperBound, n -> true);
    }
}
