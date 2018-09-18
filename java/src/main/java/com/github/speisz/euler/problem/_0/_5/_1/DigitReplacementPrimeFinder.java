package com.github.speisz.euler.problem._0._5._1;

import com.github.speisz.euler.math.SieveOfEratosthenes;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static com.github.speisz.euler.utils.MathUtil.replace;
import static com.github.speisz.euler.utils.MathUtil.upperBase10Pow;
import static java.util.stream.Collectors.toSet;

public class DigitReplacementPrimeFinder {
    private final IntPredicate primeSieve;
    private final int n;

    public DigitReplacementPrimeFinder(IntPredicate primeSieve, int n) {
        this.primeSieve = primeSieve;
        this.n = n;
    }

    public DigitReplacementPrimeFinder(int n) {
        this(SieveOfEratosthenes.createForUpperBound(upperBase10Pow(n + 1)).toIntPredicate(), n);
    }

    public Set<Integer> findReplacedAtDigits(int... indexes) {
        return findReplacedAtDigits(IntStream.of(indexes).boxed().collect(toSet()));
    }

    public Set<Integer> findReplacedAtDigits(Set<Integer> indexes) {
        return collectPrimes(numbersWithReplacedDigits(indexes));
    }

    private Set<Integer> collectPrimes(IntStream numbers) {
        int lowerBase10Pow = upperBase10Pow(n) / 10;
        return numbers
                .filter(primeSieve)
                .filter(p -> p > lowerBase10Pow)
                .boxed().collect(toSet());
    }

    private IntStream numbersWithReplacedDigits(Set<Integer> indexes) {
        return IntStream.rangeClosed(0, 9).map(digit -> replacementWithDigitAtIndexes(digit, indexes));
    }

    private int replacementWithDigitAtIndexes(int digit, Set<Integer> indexes) {
        AtomicInteger replaced = new AtomicInteger(n);
        indexes.forEach(index -> replaced.set(replace(replaced.get(), digit, index)));
        return replaced.get();
    }
}
