package com.github.speisz.euler.problem._0._5._7;

import org.apache.commons.math3.fraction.BigFraction;
import org.junit.jupiter.api.Test;

import static com.github.speisz.euler.utils.MathUtil.digits;
import static java.util.stream.Stream.iterate;
import static org.apache.commons.math3.fraction.BigFraction.getReducedFraction;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {
    static final BigFraction ONE = getReducedFraction(1, 1);

    @Test
    void countsFractionsWithNumeratorDigitCountGreaterThanDenominatorDigitCount() {
        assertThat(iterate(getReducedFraction(3, 2), previous -> previous.add(ONE).reciprocal().add(ONE))
                .limit(1_000)
                .filter(this::numeratorDigitCountGreaterDenominatorDigitCount)
                .count(), is(153L));

    }

    boolean numeratorDigitCountGreaterDenominatorDigitCount(BigFraction fraction) {
        return digits(fraction.getNumerator()).count() > digits(fraction.getDenominator()).count();
    }
}
