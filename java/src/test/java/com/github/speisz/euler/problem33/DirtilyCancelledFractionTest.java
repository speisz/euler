package com.github.speisz.euler.problem33;

import org.apache.commons.lang3.math.Fraction;
import org.junit.Test;

import static org.apache.commons.lang3.math.Fraction.getFraction;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DirtilyCancelledFractionTest {

    @Test
    public void appliesDirtyCancellation() {
        assertDirtyCancellation(getFraction(49, 98), getFraction(4, 8));
        assertDirtyCancellation(getFraction(49, 89), getFraction(4, 8));
        assertDirtyCancellation(getFraction(49, 49), getFraction(9, 9));
        assertDirtyCancellation(getFraction(30, 50), getFraction(3, 5));
        assertDirtyCancellation(getFraction(2, 3), getFraction(2, 3));
    }

    @Test
    public void appliesDirtyCancellationRecursively() {
        assertDirtyCancellation(getFraction(497, 798), getFraction(4, 8));
    }

    @Test
    public void doesNotApplyDirtyCancellationIfItWouldLeaveNumeratorOrDenominatorEmpty() {
        assertDirtyCancellation(getFraction(4, 49), getFraction(4, 49));
        assertDirtyCancellation(getFraction(49, 9), getFraction(49, 9));
        
    }

    private void assertDirtyCancellation(Fraction initial, Fraction expected) {
        assertThat(DirtilyCancelledFraction.of(initial).asFraction(), is(expected));
    }
}