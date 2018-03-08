package com.github.speisz.euler.problem10;

import java.util.function.LongPredicate;

import static java.util.stream.LongStream.rangeClosed;

public class StreamSum {
    public long get(int upperBound, LongPredicate condition) {
        return rangeClosed(1, upperBound)
                .filter(condition)
                .sum();
    }

    public long get(int upperBound) {
        return get(upperBound, n -> true);
    }
}
