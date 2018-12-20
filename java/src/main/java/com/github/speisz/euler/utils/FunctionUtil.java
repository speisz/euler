package com.github.speisz.euler.utils;

import java.util.function.UnaryOperator;

public class FunctionUtil {
    private FunctionUtil() {
        // hide default constructor
    }

    public static <T> T apply(T input, UnaryOperator<T> operator, int applyCount) {
        if (applyCount == 0) {
            return input;
        }
        return apply(operator.apply(input), operator, applyCount - 1);
    }
}
