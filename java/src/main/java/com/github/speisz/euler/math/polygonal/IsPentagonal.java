package com.github.speisz.euler.math.polygonal;

import com.github.speisz.euler.math.ToLongPredicate;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.github.speisz.euler.utils.MathUtil.isDivisible;
import static com.github.speisz.euler.utils.MathUtil.isPerfectSquare;
import static java.lang.Math.sqrt;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.LongStream.iterate;

public class IsPentagonal implements Predicate<Long>, ToLongPredicate {
    private long lastComputedPentagonal = 0;
    private long indexOfLastComputedPentagonal = 1;
    private final Set<Long> computedPentagonals;
    private final int offsetFactor;

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
        if (number > lastComputedPentagonal) {
            computedPentagonals.addAll(pentagonals(indexOfLastComputedPentagonal, offsetFactor * number).collect(toSet()));
        }
        return computedPentagonals.contains(number);
    }

    private Stream<Long> pentagonals(long startingIndex, Long upperBound) {
        return iterate(startingIndex, n -> n + 1)
                .mapToObj(n -> Pair.of(n, nthPentagonal(n)))
                .takeWhile(p -> p.getKey() <= upperBound)
                .peek(this::updateComputedState)
                .map(Pair::getValue);
    }

    private long nthPentagonal(long n) {
        return (n * (3 * n - 1)) / 2;
    }

    private void updateComputedState(Pair<Long, Long> indexAndPentagonal) {
        indexOfLastComputedPentagonal = indexAndPentagonal.getKey();
        lastComputedPentagonal = indexAndPentagonal.getValue();
    }

    /**
     * P_n=n(3n−1)/2 => n=(1±√(1+24P_n))/6
     */
    private boolean testInefficiently(Long number) {
        long radicant = 1 + 24 * number;
        return isPerfectSquare(radicant) && isDivisible(1L + (long) sqrt(radicant), 6);
    }

    private IsPentagonal(int offsetFactor) {
        this.offsetFactor = offsetFactor;
        computedPentagonals = new HashSet<>();
    }
}
