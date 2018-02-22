package com.github.speisz.euler.problem7;

import com.github.speisz.euler.utils.MathUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.valueOf;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

class PrimeFinder {

    BigInteger findNth(long n) {
        return firstNPrimes(n).stream()
                .max(BigInteger::compareTo)
                .orElseThrow(IllegalArgumentException::new);
    }

    private List<BigInteger> firstNPrimes(long n) {
        if (n == 2) {
            return new ArrayList<>(asList(MathUtils.TWO, valueOf(3)));
        }
        if (n <= 1) {
            return new ArrayList<>(singletonList(MathUtils.TWO));
        }
        List<BigInteger> primes = firstNPrimes(n - 1);
        primes.add(MathUtils.findNextPrime(primes));
        return primes;
    }
}
