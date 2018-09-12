package com.github.speisz.euler.problem14;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TEN;
import static java.math.BigInteger.valueOf;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

class CollatzChainTest {
    @Test
    void createsCollatzChainWithStartingNumber() {
        assertThat(CollatzChain.of(valueOf(13)).get().collect(toList()), contains(valuesOf(13, 40, 20, 10, 5, 16, 8, 4, 2)));
    }

    @Test
    void createsCollatzChainForBigStartingNumbers() {
        assertThat(CollatzChain.of(TEN.pow(100).add(ONE)).get().count(), is(2173L));
    }

    private BigInteger[] valuesOf(Integer... integerValues) {
        return Stream.of(integerValues).map(BigInteger::valueOf).toArray(BigInteger[]::new);
    }
}
