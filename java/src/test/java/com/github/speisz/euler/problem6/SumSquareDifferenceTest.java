package com.github.speisz.euler.problem6;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.valueOf;
import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class SumSquareDifferenceTest {
    @Test
    void computesTheDifferenceOfSumSquareAndSquaresSum() {
        assertThat(SumSquareDifference.computeFor(() -> numbersUpTo(10)), is(valueOf(2640)));
        assertThat(SumSquareDifference.computeFor(() -> numbersUpTo(100)), is(valueOf(25164150)));
        assertThat(SumSquareDifference.computeFor(() -> numbersUpTo(10000000)), is(new BigInteger("2500000166666641666665000000")));
    }

    private Stream<BigInteger> numbersUpTo(int upper) {
        return rangeClosed(1, upper).boxed().map(BigInteger::valueOf);
    }
}
