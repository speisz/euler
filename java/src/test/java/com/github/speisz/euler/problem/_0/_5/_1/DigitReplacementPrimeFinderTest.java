package com.github.speisz.euler.problem._0._5._1;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

class DigitReplacementPrimeFinderTest {

    @Test
    void findsAllPrimesByReplacingSpecifiedDigit() {
        Set<Integer> primes = new DigitReplacementPrimeFinder(13).findReplacedAtDigits(1);
        assertThat(primes, hasItems(13, 23, 43, 53, 73, 83));
    }

    @Test
    void findsAllPrimesByReplacingSpecifiedDigits() {
        Set<Integer> primes = new DigitReplacementPrimeFinder(56003).findReplacedAtDigits(1, 2);
        assertThat(primes, hasItems(56003, 56113, 56333, 56443, 56663, 56773, 56993));
    }
}
