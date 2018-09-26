package com.github.speisz.euler.utils;

import com.github.speisz.euler.math.ToLongPredicate;

import java.util.function.Predicate;

public class LongPalindromeCheck implements Predicate<Long>, ToLongPredicate {

    private StringPalindromeCheck stringPalindromeCheck = StringPalindromeCheck.create();

    private LongPalindromeCheck() {
    }

    public static LongPalindromeCheck create() {
        return new LongPalindromeCheck();
    }

    @Override
    public boolean test(Long number) {
        return stringPalindromeCheck.test(String.valueOf(number));
    }
}
