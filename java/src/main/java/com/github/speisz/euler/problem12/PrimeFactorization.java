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
                int multiplicityOfDivisorK = findMultiplicityOfDivisor(n, k);
                primeFactorization.put(k, multiplicityOfDivisorK);
                return findNextPrimeAndPutToMap(n.divide(k.pow(multiplicityOfDivisorK)), primeFactorization);
            }
        }
        return primeFactorization;
    }

    private static int findMultiplicityOfDivisor(BigInteger divident, BigInteger divisor) {
        if (!isDivisible(divident, divisor)) {
            return 0;
        }
        return findMultiplicityOfDivisor(divident.divide(divisor), divisor) + 1;
    }
}
