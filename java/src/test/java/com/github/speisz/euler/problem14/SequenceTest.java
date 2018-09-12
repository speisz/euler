package com.github.speisz.euler.problem14;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class SequenceTest {
    @Test
    void generatesSimpleSequenceWithBreakCondition() {
        assertThat(Sequence.<BigInteger>builder()
                .withSeed(ONE)
                .withRule(ONE::add)
                .withCondition(((Predicate<BigInteger>) valueOf(5)::equals).negate())
                .build()
                .compute()
                .collect(toList()), contains(valuesOf(1, 2, 3, 4)));
    }

    private BigInteger[] valuesOf(Integer... integerValues) {
        return Stream.of(integerValues).map(BigInteger::valueOf).toArray(BigInteger[]::new);
    }
}
