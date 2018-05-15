package com.github.speisz.euler.utils;

import java.util.function.Predicate;

public class StringPalindromeCheck implements Predicate<String> {

    private StringPalindromeCheck() {
    }

    public static StringPalindromeCheck create() {
        return new StringPalindromeCheck();
    }

    @Override
    public boolean test(String string) {
        return isOneCharacterOrEmpty(string) || !firstAndLastCharacterDiffer(string) && test(cutFirstAndLastCharacter(string));
    }

    private boolean isOneCharacterOrEmpty(String string) {
        return string.length() <= 1;
    }

    private String cutFirstAndLastCharacter(String string) {
        return string.substring(1, string.length() - 1);
    }

    private boolean firstAndLastCharacterDiffer(String string) {
        return string.charAt(0) != string.charAt(string.length() - 1);
    }
}
