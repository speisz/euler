package com.github.speisz.euler.math;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SieveOfEratosthenesTest {

    @Test
    void testsIfNumberIsPrime() {
        SieveOfEratosthenes sieve = SieveOfEratosthenes.createForUpperBound(10);

        IntStream.of(2, 3, 5, 7).forEach(n -> assertTrue(sieve.test(n), n + " is prime."));
        IntStream.of(4, 6, 9, 10, 1, 0, -1, -3).forEach(n -> assertFalse(sieve.test(n), n + " is not prime."));
    }

    @Test
    void throwsExceptionIfNumberToTestIsOutOfRange() {
        SieveOfEratosthenes sieve = SieveOfEratosthenes.createForUpperBound(10);
        Exception thrownException = assertThrows(IllegalArgumentException.class, () -> sieve.test(11));
        assertThat(thrownException.getMessage(), containsString("11"));
    }
}
