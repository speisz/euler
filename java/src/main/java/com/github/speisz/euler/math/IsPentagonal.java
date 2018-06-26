package com.github.speisz.euler.math;

import java.util.function.Predicate;

import static com.github.speisz.euler.utils.MathUtil.isDivisible;
import static com.github.speisz.euler.utils.MathUtil.isPerfectSquare;
import static java.lang.Math.sqrt;

public class IsPentagonal implements Predicate<Long>, ToLongPredicate {
    public static IsPentagonal create() {
        return new IsPentagonal();
    }

    /**
     * P_n=n(3n−1)/2 => n=(1±√(1+24P_n))/6
     */
    public boolean test(Long number) {
        long radicant = 1 + 24 * number;
        return isPerfectSquare(radicant) && isDivisible(1L + (long) sqrt(radicant), 6);
    }

    private IsPentagonal() {
    }
}
