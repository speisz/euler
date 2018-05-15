package com.github.speisz.euler.utils;

import java.util.function.Predicate;

public class IntegerPalindromeCheck implements Predicate<Integer> {

    private StringPalindromeCheck stringPalindromeCheck = StringPalindromeCheck.create();

    private IntegerPalindromeCheck() {
    }

    public static IntegerPalindromeCheck create() {
        return new IntegerPalindromeCheck();
    }

    @Override
    public boolean test(Integer number) {
        return stringPalindromeCheck.test(String.valueOf(number));
    }
}
