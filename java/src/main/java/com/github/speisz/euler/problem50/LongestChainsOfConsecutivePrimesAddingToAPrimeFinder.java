package com.github.speisz.euler.problem50;

import com.github.speisz.euler.math.SieveOfEratosthenes;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.IntStream.iterate;

class LongestChainsOfConsecutivePrimesAddingToAPrimeFinder {
    private final IntPredicate primeSieve;
    private final int upper;

    private LongestChainsOfConsecutivePrimesAddingToAPrimeFinder(int upper) {
        this.upper = upper;
        primeSieve = new SieveOfEratosthenes(upper).toIntPredicate();
    }

    static LongestChainsOfConsecutivePrimesAddingToAPrimeFinder createLongestChainsOfConsecutivePrimesAddingToAPrimeFinder(int upper) {
        return new LongestChainsOfConsecutivePrimesAddingToAPrimeFinder(upper);
    }

    PrimeChain find() {
        return find(1);
    }

    PrimeChain find(int lengthOfLongestChainKnownInAdvance) {
        return iterate(2, i -> i < upper / lengthOfLongestChainKnownInAdvance, i -> i + 1)
                .filter(primeSieve::test)
                .boxed()
                .flatMap(initial -> findAllPrimeChainsStartingWith(initial, upper))
                .max(comparing(PrimeChain::getLength)).orElseThrow();
    }

    private Stream<PrimeChain> findAllPrimeChainsStartingWith(int initial, int upperBoundForSum) {
        AtomicInteger sum = new AtomicInteger(0);
        AtomicInteger length = new AtomicInteger(0);
        return iterate(initial, i -> i + 1)
                .takeWhile(p -> sum.get() + p < upperBoundForSum)
                .filter(primeSieve::test)
                .peek(p -> length.addAndGet(1))
                .filter(p -> primeSieve.test(sum.addAndGet(p)))
                .mapToObj(p -> PrimeChain.of(sum.get(), length.get(), initial));
    }

    static class PrimeChain {
        private final int sum;
        private final int length;
        private final int initial;

        PrimeChain(int sum, int length, int initial) {
            this.sum = sum;
            this.length = length;
            this.initial = initial;
        }

        public static PrimeChain of(int sum, int length, int initial) {
            return new PrimeChain(sum, length, initial);
        }

        int getLength() {
            return length;
        }

        public int getSum() {
            return sum;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(null, ToStringStyle.NO_CLASS_NAME_STYLE)
                    .append("sum", sum)
                    .append("length", length)
                    .append("initial", initial)
                    .toString();
        }
    }
}
