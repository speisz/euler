package com.github.speisz.euler.math;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashSet;
import java.util.OptionalLong;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.github.speisz.euler.utils.MathUtil.isDivisible;
import static com.github.speisz.euler.utils.MathUtil.isPerfectSquare;
import static com.github.speisz.euler.utils.StreamUtil.lastElement;
import static java.lang.Math.sqrt;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.LongStream.iterate;

/**
 * H_n=n(2n−1)
 */
public class IsHexagonal implements Predicate<Long>, ToLongPredicate {
    private long lastComputedHexagonal = 0;
    private long indexOfLastComputedHexagonal = 1;
    private final Set<Long> computedHexagonals;
    private int offsetFactor;

    public static IsHexagonal create() {
        return create(1);
    }

    public static IsHexagonal create(int offsetFactor) {
        return new IsHexagonal(offsetFactor);
    }

    public boolean test(Long number) {
        return testWithState(number);
    }

    private boolean testWithState(Long number) {
        if (number > lastComputedHexagonal) {
            computedHexagonals.addAll(hexagonals(indexOfLastComputedHexagonal, offsetFactor * number).collect(toSet()));
        }
        return computedHexagonals.contains(number);
    }

    private Stream<Long> hexagonals(long startingIndex, Long upperBound) {
        return iterate(startingIndex, n -> n + 1)
                .mapToObj(n -> Pair.of(n, nthHexagonal(n)))
                .takeWhile(p -> p.getKey() <= upperBound)
                .peek(this::updateComputedState)
                .map(Pair::getValue);
    }

    private long nthHexagonal(long n) {
        return n * (2 * n - 1);
    }

    private void updateComputedState(Pair<Long, Long> indexAndHexagonal) {
        indexOfLastComputedHexagonal = indexAndHexagonal.getKey();
        lastComputedHexagonal = indexAndHexagonal.getValue();
    }

    private OptionalLong lastHexagonalLowerOrEqualTo(Long number) {
        return lastElement(iterate(1L, n -> n + 1)
                .map(this::nthHexagonal)
                .takeWhile(h -> h <= number));
    }

    /**
     * H_n=n(2n−1) => n=(1+√(1+8H_n))/4
     */
    private boolean testInefficiently(Long number) {
        long radicant = 1 + 8 * number;
        return isPerfectSquare(radicant) && isDivisible(1L + (long) sqrt(radicant), 4);
    }

    private boolean testSemiEfficiently(Long number) {
        OptionalLong hexagonal = lastHexagonalLowerOrEqualTo(number);
        if (!hexagonal.isPresent()) {
            return false;
        }
        return number.equals(hexagonal.getAsLong());
    }

    private IsHexagonal(int offsetFactor) {
        this.offsetFactor = offsetFactor;
        computedHexagonals = new HashSet<>();
    }
}
