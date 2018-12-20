package com.github.speisz.euler.problem._0._6._0;

import com.github.speisz.euler.math.SieveOfEratosthenes;

import java.util.Set;
import java.util.stream.Stream;

import static com.github.speisz.euler.utils.CollectionUtil.setOf;
import static com.github.speisz.euler.utils.FunctionUtil.apply;
import static com.github.speisz.euler.utils.IntUtil.concat;
import static java.util.stream.IntStream.rangeClosed;

public class ConcatPrimeFinder {
    private final SieveOfEratosthenes primeSieve;
    private final int upperBoundForPrimes;

    private ConcatPrimeFinder(int upperBoundForPrimes) {
        this.upperBoundForPrimes = upperBoundForPrimes;
        primeSieve = SieveOfEratosthenes.forUpperBound(concat(upperBoundForPrimes, upperBoundForPrimes));
    }

    public static ConcatPrimeFinder forUpperBound(int upperBoundForPrimes) {
        return new ConcatPrimeFinder(upperBoundForPrimes);
    }

    public Stream<Set<Integer>> findConcatenationPrimes(int length) {
        return apply(rangeClosed(3, upperBoundForPrimes).boxed()
                .filter(primeSieve)
                .map(Set::of), stream -> stream.flatMap(this::findFor).distinct(), length);
    }

    Stream<Set<Integer>> findFor(Set<Integer> givenNumbers) {
        return rangeClosed(3, upperBoundForPrimes)
                .filter(primeSieve.toIntPredicate())
                .filter(prime -> !givenNumbers.contains(prime))
                .mapToObj(prime -> setOf(givenNumbers, prime))
                .filter(numbers -> IntegerConcatenations.getFor(numbers).allMatch(primeSieve));
    }

    Stream<Set<Integer>> findFor(int givenNumber) {
        return findFor(Set.of(givenNumber));
    }
}
