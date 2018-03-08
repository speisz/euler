package com.github.speisz.euler.problem14;

import org.junit.Test;

import static java.math.BigInteger.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SeedForMaximumChainTest {
    private final SeedForMaximumChain seedForMaximumChain = new SeedForMaximumChain(n -> CollatzChain.of(n).get());

    @Test
    public void findsStartingNumberOfCollatzWithLongestChain() {
        assertThat(seedForMaximumChain.findUpTo(1_000_000L), is(valueOf(837799L)));
    }
}
