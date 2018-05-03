package com.github.speisz.euler.problem27;

import com.github.speisz.euler.math.QuadraticForm;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NumberOfConsecutivePrimesTest {

    @Test
    public void countsNumberOfConsecutivePrimes() {
        assertThat(NumberOfConsecutivePrimes.of(QuadraticForm.withCoefficients(1, 41)), is(40L));
        assertThat(NumberOfConsecutivePrimes.of(QuadraticForm.withCoefficients(-79, 1601)), is(80L));
    }
}