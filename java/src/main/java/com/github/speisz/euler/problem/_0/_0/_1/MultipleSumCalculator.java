package com.github.speisz.euler.problem._0._0._1;

import java.util.Collection;
import java.util.Set;
import java.util.function.ToIntFunction;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toSet;

class MultipleSumCalculator {
    private static final ToIntFunction<Integer> IDENTITY = integer -> integer;

    private final Set<MultipleCalculator> multipleCalculators;

    private MultipleSumCalculator(int... bases) {
        multipleCalculators = stream(bases).boxed()
                .map(MultipleCalculator::forBase)
                .collect(toSet());
    }

    static MultipleSumCalculator forBases(int... bases) {
        return new MultipleSumCalculator(bases);
    }

    int computeSumOfMultiplesUpTo(int boundary) {
        return multipleCalculators.stream()
                .map(multipleCalculator -> multipleCalculator.computeUpTo(boundary))
                .flatMap(Collection::stream)
                .distinct()
                .mapToInt(IDENTITY)
                .sum();
    }
}
