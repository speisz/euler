package com.github.speisz.euler.problem7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static com.github.speisz.euler.utils.MathUtils.isDivisible;
import static java.math.BigInteger.valueOf;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.stream.Stream.iterate;

class PrimeFinder {

    private static final BigInteger TWO = valueOf(2);

    BigInteger findNth(long n) {
        return firstNPrimes(n).stream()
                .max(BigInteger::compareTo)
                .orElseThrow(IllegalArgumentException::new);
    }

    private List<BigInteger> firstNPrimes(long n) {
        if (n == 2) {
            return new ArrayList<>(asList(TWO, valueOf(3)));
        }
        if (n <= 1) {
            return new ArrayList<>(singletonList(TWO));
        }
        List<BigInteger> primes = firstNPrimes(n - 1);
        primes.add(findNextPrime(primes));
        return primes;
    }

    @SuppressWarnings({"squid:S3655", "ConstantConditions"})
    private BigInteger findNextPrime(List<BigInteger> primes) {
        return iterate(primes.get(primes.size() - 1).add(TWO), m -> m.add(TWO))
                .filter(m -> isNotDivisibleByAny(m, primes))
                .findFirst()
                .get();
    }

    private boolean isNotDivisibleByAny(BigInteger number, List<BigInteger> potentialDivisors) {
        return potentialDivisors.stream().noneMatch(divisor -> isDivisible(number, divisor));
    }
}
