package com.github.speisz.euler.problem4;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LargestPalindromeProductTest {

    private LargestPalindromeProduct largestPalindromeProduct = new LargestPalindromeProduct();

    @Test
    public void findsLargestPalindromeProductForOneDigitNumbers() {
        assertThat(largestPalindromeProduct.compute(1), is(9));
    }

    @Test
    public void findsLargestPalindromeProductForTwoDigitNumbers() {
        assertThat(largestPalindromeProduct.compute(2), is(9009));
    }

    @Test
    public void findsLargestPalindromeProductForThreeDigitNumbers() {
        assertThat(largestPalindromeProduct.compute(3), is(906609));
    }

    @Test
    public void findsLargestPalindromeProductForFourDigitNumbers() {
        assertThat(largestPalindromeProduct.compute(4), is(99000099)); // takes ~4s
    }
}
