package com.github.speisz.euler.utils;

import com.github.speisz.euler.math.ToIntPredicate;

import java.util.function.Predicate;

public class IntegerPalindromeCheck implements Predicate<Integer>, ToIntPredicate {

    private LongPalindromeCheck longPalindromeCheck = LongPalindromeCheck.create();

    private IntegerPalindromeCheck() {
    }

    public static IntegerPalindromeCheck create() {
        return new IntegerPalindromeCheck();
    }

    @Override
    public boolean test(Integer number) {
        return longPalindromeCheck.test(Long.valueOf(number));
    }
}
