package com.github.speisz.euler.problem14;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.util.Comparator.comparing;
import static java.util.stream.Stream.iterate;

public class SeedForMaximumChain {
    private Function<BigInteger, Stream<BigInteger>> chainSupplier;

    SeedForMaximumChain(Function<BigInteger, Stream<BigInteger>> chainSupplier) {
        this.chainSupplier = chainSupplier;
    }

    BigInteger findUpTo(long upperBound) {
        return iterate(ONE, ONE::add)
                .limit(upperBound)
                .map(n -> SeedAndChainCount.of(n, chainSupplier.apply(n).count()))
                .max(comparing(SeedAndChainCount::getCount))
                .map(SeedAndChainCount::getSeed)
                .orElseThrow(() -> new RuntimeException("Did not compute any chain."));
    }

    static class SeedAndChainCount {
        BigInteger seed;
        long count;

        SeedAndChainCount(BigInteger seed, long count) {
            this.seed = seed;
            this.count = count;
        }

        BigInteger getSeed() {
            return seed;
        }

        long getCount() {
            return count;
        }

        static SeedAndChainCount of(BigInteger seed, long count) {
            return new SeedAndChainCount(seed, count);
        }
    }
}
