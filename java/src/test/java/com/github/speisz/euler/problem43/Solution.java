package com.github.speisz.euler.problem43;

import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;

import static com.google.common.primitives.Ints.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    private SubstringDivisibleZeroNinePandigitals substringDivisibleZeroNinePandigitals = new SubstringDivisibleZeroNinePandigitals(
            Range.between(2, 8), 3, asList(2, 3, 5, 7, 11, 13, 17));

    @Test
    void findsTheSumOfSubstringDivisiblePandigitalNumbers() {
        assertThat(substringDivisibleZeroNinePandigitals.stream()
//                .peek(System.out::println)
                .sum(), is(16695334890L));
    }
}
