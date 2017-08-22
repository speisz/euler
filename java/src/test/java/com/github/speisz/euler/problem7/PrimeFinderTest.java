package com.github.speisz.euler.problem7;

import org.junit.Test;

import static java.math.BigInteger.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PrimeFinderTest {

    private PrimeFinder primeFinder = new PrimeFinder();

    @Test
    public void findsNthPrimeForSmallPrimes() {
        assertThat(primeFinder.findNth(1), is(valueOf(2)));
        assertThat(primeFinder.findNth(2), is(valueOf(3)));
        assertThat(primeFinder.findNth(3), is(valueOf(5)));
        assertThat(primeFinder.findNth(4), is(valueOf(7)));
        assertThat(primeFinder.findNth(5), is(valueOf(11)));
    }

    @Test
    public void findsNthPrimeForLargerPrimes() {
        assertThat(primeFinder.findNth(10001), is(valueOf(104743)));
    }
}
