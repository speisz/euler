package com.github.speisz.euler.problem4;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntegerPalindromeCheckTest {

    private IntegerPalindromeCheck palindromeCheck = new IntegerPalindromeCheck();

    @Test
    public void statesNonPalindromesCorrectly() {
        assertFalse(palindromeCheck.test(12));
        assertFalse(palindromeCheck.test(1234312));
    }

    @Test
    public void statesPalindromesCorrectly() {
        assertTrue(palindromeCheck.test(1));
        assertTrue(palindromeCheck.test(1234321));
    }
}
