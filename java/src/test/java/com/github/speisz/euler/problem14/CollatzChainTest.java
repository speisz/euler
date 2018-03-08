package com.github.speisz.euler.problem14;

import org.junit.Test;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.valueOf;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class CollatzChainTest {
    @Test
    public void createsCollatzChainWithStartingNumber() {
        assertThat(CollatzChain.of(valueOf(13)).get().collect(toList()), contains(valuesOf(13, 40, 20, 10, 5, 16, 8, 4, 2, 1)));
    }

    private BigInteger[] valuesOf(Integer... integerValues) {
        return Stream.of(integerValues).map(BigInteger::valueOf).toArray(BigInteger[]::new);
    }
}
