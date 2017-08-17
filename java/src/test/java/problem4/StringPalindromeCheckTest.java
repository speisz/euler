package problem4;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringPalindromeCheckTest {

    private StringPalindromeCheck stringPalindromeCheck = new StringPalindromeCheck();

    @Test
    public void statesSingleCharacterStringsAsPalindromes() {
        assertTrue(stringPalindromeCheck.test("a"));
    }

    @Test
    public void statesNonPalindromesCorrectly() {
        assertFalse(stringPalindromeCheck.test("ab"));
    }

    @Test
    public void statesPalindromesCorrectly() {
        assertTrue(stringPalindromeCheck.test("aba"));
        assertTrue(stringPalindromeCheck.test("911acca119"));
    }
}
