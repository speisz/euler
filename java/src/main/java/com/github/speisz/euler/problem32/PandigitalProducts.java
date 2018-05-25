package com.github.speisz.euler.problem32;

import com.github.speisz.euler.utils.BoundedStream;

import java.util.stream.Stream;

import static com.github.speisz.euler.math.IsPandigital.isPandigital;
import static com.github.speisz.euler.utils.IntUtil.concat;
import static com.github.speisz.euler.utils.MathUtil.digits;
import static java.util.stream.IntStream.rangeClosed;

public class PandigitalProducts {

    private static final int UPPER_BOUND_FOR_FACTOR = 4873;

    public static Stream<Integer> stream() {
        return rangeClosed(2, UPPER_BOUND_FOR_FACTOR).boxed()
                .flatMap(firstFactor ->
                        BoundedStream.of(rangeClosed(firstFactor + 1, UPPER_BOUND_FOR_FACTOR).boxed())
                                .withConditionInclusive(secondFactor -> digitCountOfMultiplication(firstFactor, secondFactor) <= 9)
                                .get()
                                .filter(secondFactor -> digitCountOfMultiplication(firstFactor, secondFactor) == 9)
                                .filter(secondFactor -> isPandigitalMultiplication(firstFactor, secondFactor))
                                .map(secondFactor -> firstFactor * secondFactor))
                .distinct();
    }

    private static long digitCountOfMultiplication(Integer firstFactor, Integer secondFactor) {
        return digitCount(firstFactor) + digitCount(secondFactor) + digitCount(firstFactor * secondFactor);
    }

    private static long digitCount(int product) {
        return digits(product).count();
    }

    private static boolean isPandigitalMultiplication(Integer firstFactor, Integer secondFactor) {
        return isPandigital(concat(firstFactor, secondFactor, firstFactor * secondFactor));
    }
}
