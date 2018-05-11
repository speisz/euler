package com.github.speisz.euler.problem33;

import org.apache.commons.lang3.math.Fraction;
import org.junit.Test;

import java.util.List;

import static com.github.speisz.euler.utils.StreamUtil.pairStream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static org.apache.commons.lang3.math.Fraction.getFraction;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {

    @Test
    public void findAllValidDirtyCancellationsOfTwoDigitNumeratorAndDenominator() {
        List<Fraction> fractions = pairStream(() -> range(11, 99).boxed())
                .map(pair -> getFraction(pair.getLeft(), pair.getRight()))
                .filter(fraction -> fraction.getDenominator() % 10 != 0)
                .filter(this::dirtyCancellationGivesCorrectCancellation)
                .filter(fraction -> fraction.compareTo(Fraction.ONE) < 0)
                .collect(toList());

        assertThat(fractions.stream().reduce(Fraction.ONE,Fraction::multiplyBy).reduce().getDenominator(), is(100));
    }

    private boolean dirtyCancellationGivesCorrectCancellation(Fraction fraction) {
        Fraction dirtyCancellation = DirtilyCancelledFraction.of(fraction).asFraction();
        return dirtyCancellation.compareTo(fraction) == 0 && dirtyCancellation.getDenominator() != fraction.getDenominator();
    }
}
