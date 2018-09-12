package com.github.speisz.euler.problem4;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LargestPalindromeProductTest {

    private LargestPalindromeProduct largestPalindromeProduct = new LargestPalindromeProduct();

    @Test
    void findsLargestPalindromeProductForOneDigitNumbers() {
        assertThat(largestPalindromeProduct.compute(1), is(9));
    }

    @Test
    void findsLargestPalindromeProductForTwoDigitNumbers() {
        assertThat(largestPalindromeProduct.compute(2), is(9009));
    }

    @Test
    void findsLargestPalindromeProductForThreeDigitNumbers() {
        assertThat(largestPalindromeProduct.compute(3), is(906609));
    }

    @Test
    void findsLargestPalindromeProductForFourDigitNumbers() {
        assertThat(largestPalindromeProduct.compute(4), is(99000099)); // takes ~4s
    }
}
