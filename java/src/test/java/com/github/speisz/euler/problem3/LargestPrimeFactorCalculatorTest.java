package com.github.speisz.euler.problem3;

import org.junit.Test;

import static java.math.BigInteger.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static com.github.speisz.euler.testutils.Assertions.assertExceptionIsThrown;

public class LargestPrimeFactorCalculatorTest {

    private LargestPrimeFactorCalculator calculator = new LargestPrimeFactorCalculator();

    @Test
    public void determineLargestPrimeFactorForPrimes() {
        assertThat(calculator.calculateFor(valueOf(2)), is(valueOf(2)));
        assertThat(calculator.calculateFor(valueOf(3)), is(valueOf(3)));
        assertThat(calculator.calculateFor(valueOf(5)), is(valueOf(5)));
    }

    @Test
    public void determinesLargestPrimeFactorForNonPrimes() {
        assertThat(calculator.calculateFor(valueOf(4)), is(valueOf(2)));
        assertThat(calculator.calculateFor(valueOf(6)), is(valueOf(3)));
        assertThat(calculator.calculateFor(valueOf(12)), is(valueOf(3)));
        assertThat(calculator.calculateFor(valueOf(15)), is(valueOf(5)));
    }

    @Test
    public void determinesLargestPrimeFactorForBiggerNumbers() {
        assertThat(calculator.calculateFor(valueOf(11).pow(100).multiply(valueOf(31).pow(10))), is(valueOf(31)));
    }

    @Test
    public void doesNotAcceptValuesLowerOrEqualTo1() {
        assertExceptionIsThrown(() -> calculator.calculateFor(valueOf(1)), IllegalArgumentException.class);
        assertExceptionIsThrown(() -> calculator.calculateFor(valueOf(0)), IllegalArgumentException.class);
        assertExceptionIsThrown(() -> calculator.calculateFor(valueOf(-2)), IllegalArgumentException.class);
    }
}
