package com.github.speisz.euler.math.polygonal;

import com.github.speisz.euler.math.ToLongPredicate;

import java.util.function.Predicate;

import static com.github.speisz.euler.utils.MathUtil.isDivisible;
import static com.github.speisz.euler.utils.MathUtil.isPerfectSquare;
import static java.lang.Math.sqrt;

public class IsPentagonal implements Predicate<Long>, ToLongPredicate {
    private final PolygonalsComputation polygonalsComputation = new PolygonalsComputation(Polygonals::pentagonal);
    private final int offsetFactor;

    private IsPentagonal(int offsetFactor) {
        this.offsetFactor = offsetFactor;
    }

    public static IsPentagonal create() {
        return create(1);
    }

    public static IsPentagonal create(int offsetFactor) {
        return new IsPentagonal(offsetFactor);
    }

    public boolean test(Long number) {
        return testWithState(number);
    }

    private boolean testWithState(Long number) {
        return polygonalsComputation.getUpTo(number * offsetFactor).contains(number);
    }

    /**
     * P_n=n(3n−1)/2 => n=(1±√(1+24P_n))/6
     */
    private boolean testInefficiently(Long number) {
        long radicant = 1 + 24 * number;
        return isPerfectSquare(radicant) && isDivisible(1L + (long) sqrt(radicant), 6);
    }
}
