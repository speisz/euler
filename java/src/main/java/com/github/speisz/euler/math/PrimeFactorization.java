package com.github.speisz.euler.math;

import com.github.speisz.euler.utils.MathUtil;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static com.github.speisz.euler.utils.MathUtil.isDivisible;
import static com.github.speisz.euler.utils.MathUtil.isPrime;
import static com.github.speisz.euler.utils.MathUtil.lowerOrEqual;
import static com.github.speisz.euler.utils.MathUtil.pow;
import static java.math.BigInteger.ONE;

public class PrimeFactorization {
    public static Map<BigInteger, Integer> of(BigInteger n) {
        return findNextPrimeAndPutToMap(n, new HashMap<>());
    }

    public static Map<Integer, Integer> of(int n) {
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

    private static Map<Integer, Integer> findNextPrimeAndPutToMap(int n, Map<Integer, Integer> primeFactorization) {
        if (n == 1) {
            return primeFactorization;
        }
        for (int k = 1; k <= n; k++) {
            if (isDivisible(n, k) && isPrime(k)) {
                int multiplicityOfDivisorK = findMultiplicityOfDivisor(n, k);
                primeFactorization.put(k, multiplicityOfDivisorK);
                return findNextPrimeAndPutToMap(n / ((int) pow(k, multiplicityOfDivisorK)), primeFactorization);
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

    private static int findMultiplicityOfDivisor(int divident, int divisor) {
        if (!isDivisible(divident, divisor)) {
            return 0;
        }
        return findMultiplicityOfDivisor(divident / divisor, divisor) + 1;
    }
}
