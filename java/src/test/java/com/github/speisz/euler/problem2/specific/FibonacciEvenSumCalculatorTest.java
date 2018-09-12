package com.github.speisz.euler.problem2.specific;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static java.math.BigInteger.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class FibonacciEvenSumCalculatorTest {

    private FibonacciEvenSumCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new FibonacciEvenSumCalculator();
    }

    @Test
    void sumsFibonacciNumbersUpToBoundaryWithGivenCondition() {
        assertThat(calculator.sum(1), is(valueOf(0)));
        assertThat(calculator.sum(2), is(valueOf(2)));
        assertThat(calculator.sum(20), is(valueOf(2 + 8)));
        assertThat(calculator.sum(50), is(valueOf(2 + 8 + 34)));
    }

    @Test
    void sumsFibonacciNumbersUpToBoundaryWithGivenConditionForLargeNumbers() {
        assertThat(calculator.sum(Integer.MAX_VALUE), is(valueOf(1_485_607_536)));
        assertThat(calculator.sum(Long.MAX_VALUE), is(valueOf(3_770_056_902_373_173_214L)));
    }

    @Test
    void sumsFibonacciNumbersUpToBoundaryWithGivenConditionForEvenLargerNumbers() {
        assertThat(calculator.sum(BigInteger.valueOf(2).pow(1000)).toString(), is("5124626790246109409208802233190843952412235260724962779588117682353682567940660271047251127033343569440125835909319019727718402174460418623984333571845544246426297972857730441069662537517947357773464679502571056902330745954251917267529361675218187268003108404052656159168719864762594440633225057958560"));
    }
}
