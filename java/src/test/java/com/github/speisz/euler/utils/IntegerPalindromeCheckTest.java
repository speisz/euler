package com.github.speisz.euler.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntegerPalindromeCheckTest {

    private IntegerPalindromeCheck palindromeCheck = IntegerPalindromeCheck.create();

    @Test
    void statesNonPalindromesCorrectly() {
        assertFalse(palindromeCheck.test(12));
        assertFalse(palindromeCheck.test(1234312));
    }

    @Test
    void statesPalindromesCorrectly() {
        assertTrue(palindromeCheck.test(1));
        assertTrue(palindromeCheck.test(1234321));
    }
}
