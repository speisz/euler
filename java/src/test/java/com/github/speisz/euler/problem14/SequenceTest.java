package com.github.speisz.euler.problem14;

import org.junit.Test;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class SequenceTest {
    @Test
    public void generatesSimpleSequenceWithBreakCondition() {
        assertThat(Sequence.<BigInteger>builder()
                .withSeed(ONE)
                .withRule(ONE::add)
                .withBreakCondition(valueOf(5)::equals)
                .build()
                .compute()
                .collect(toList()), contains(valuesOf(1, 2, 3, 4, 5)));
    }

    private BigInteger[] valuesOf(Integer... integerValues) {
        return Stream.of(integerValues).map(BigInteger::valueOf).toArray(BigInteger[]::new);
    }
}
