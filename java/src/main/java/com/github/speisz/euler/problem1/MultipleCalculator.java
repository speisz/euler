package com.github.speisz.euler.problem1;

import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

class MultipleCalculator {
    private int base;

    private MultipleCalculator(int base) {
        this.base = base;
    }

    static MultipleCalculator forBase(int base) {
        return new MultipleCalculator(base);
    }

    Set<Integer> computeUpTo(int boundary) {
        return IntStream.rangeClosed(base, boundary)
                .filter(value -> value % base == 0)
                .boxed()
                .collect(toSet());
    }
}
