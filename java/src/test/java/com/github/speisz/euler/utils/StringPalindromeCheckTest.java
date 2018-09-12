package com.github.speisz.euler.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringPalindromeCheckTest {

    private StringPalindromeCheck stringPalindromeCheck = StringPalindromeCheck.create();

    @Test
    void statesSingleCharacterStringsAsPalindromes() {
        assertTrue(stringPalindromeCheck.test("a"));
    }

    @Test
    void statesNonPalindromesCorrectly() {
        assertFalse(stringPalindromeCheck.test("ab"));
    }

    @Test
    void statesPalindromesCorrectly() {
        assertTrue(stringPalindromeCheck.test("aba"));
        assertTrue(stringPalindromeCheck.test("911acca119"));
    }
}
