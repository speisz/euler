package com.github.speisz.euler.problem._0._2._3;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static com.github.speisz.euler.problem._0._2._3.IsAbundantNumber.isAbundantNumber;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    private static final int SMALLEST_ABUNDANT_NUMBER = 12;
    private static final int UPPER_BORDER_FOR_ABUNDANT_NUMBERS = 28_123;

    @Test
    void computesSumOfNonAbundantSumNumbers() {
        Set<Integer> abundantNumbers = rangeClosed(SMALLEST_ABUNDANT_NUMBER, UPPER_BORDER_FOR_ABUNDANT_NUMBERS)
                .filter(isAbundantNumber())
                .boxed()
                .collect(toSet());

        Set<Integer> abundantNumberSums = abundantNumbers.stream()
                .flatMap(i -> abundantNumbers.stream().map(j -> i + j))
                .distinct()
                .collect(toSet());

        int sumOfNonAbundantSumNumbers = rangeClosed(1, UPPER_BORDER_FOR_ABUNDANT_NUMBERS)
                .filter(i -> !abundantNumberSums.contains(i))
                .sum();

        assertThat(sumOfNonAbundantSumNumbers, is(4_179_871));
    }
}
