package com.github.speisz.euler.problem12;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static com.github.speisz.euler.utils.MathUtil.isDivisible;
import static com.github.speisz.euler.utils.MathUtil.isPrime;
import static com.github.speisz.euler.utils.MathUtil.lowerOrEqual;
import static java.math.BigInteger.ONE;

public class PrimeFactorization {
    public static Map<BigInteger, Integer> of(BigInteger n) {
        return findNextPrimeAndPutToMap(n, new HashMap<>());
    }

    private static Map<BigInteger, Integer> findNextPrimeAndPutToMap(BigInteger n, Map<BigInteger, Integer> primeFactorization) {
        if (n.equals(ONE)) {
            return primeFactorization;
        }
        for (BigInteger k = ONE; lowerOrEqual(k, n); k = k.add(ONE)) {
            if (isDivisible(n, k) && isPrime(k)) {
                addToPrimeFactorization(k, primeFactorization);
                return findNextPrimeAndPutToMap(n.divide(k), primeFactorization);
            }
        }
        return primeFactorization;
    }

    private static void addToPrimeFactorization(BigInteger k, Map<BigInteger, Integer> primeFactorization) {
        if (primeFactorization.containsKey(k)) {
            primeFactorization.replace(k, primeFactorization.get(k) + 1);
        } else {
            primeFactorization.put(k, 1);
        }
    }
}
