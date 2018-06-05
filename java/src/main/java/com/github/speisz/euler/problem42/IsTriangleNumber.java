package com.github.speisz.euler.problem42;

import java.util.function.Predicate;

import static com.github.speisz.euler.utils.MathUtil.isPerfectSquare;

public class IsTriangleNumber implements Predicate<Integer> {
    private IsTriangleNumber() {
    }

    public static IsTriangleNumber create() {
        return new IsTriangleNumber();
    }

    @Override
    public boolean test(Integer n) {
        return isPerfectSquare(8 * n + 1);
    }
}
