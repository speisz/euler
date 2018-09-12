package com.github.speisz.euler.problem._0._1._4;

import org.junit.jupiter.api.Test;

import static java.math.BigInteger.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class SeedForMaximumChainTest {
    private final SeedForMaximumChain seedForMaximumChain = new SeedForMaximumChain(n -> CollatzChain.of(n).get());

    @Test
    void findsStartingNumberOfCollatzWithLongestChain() {
        assertThat(seedForMaximumChain.findUpTo(1_000_000L), is(valueOf(837799L)));
    }
}
