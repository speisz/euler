package com.github.speisz.euler.problem23;

import org.junit.Test;

import java.util.Set;

import static com.github.speisz.euler.problem23.IsAbundantNumber.isAbundantNumber;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {

    private static final int SMALLEST_ABUNDANT_NUMBER = 12;
    private static final int UPPER_BORDER_FOR_ABUNDANT_NUMBERS = 28_123;

    @Test
    public void computesSumOfNonAbundantSumNumbers() {
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
