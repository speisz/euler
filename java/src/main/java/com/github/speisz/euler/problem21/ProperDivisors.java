package com.github.speisz.euler.problem21;

import com.github.speisz.euler.problem12.PrimeFactorization;
import com.github.speisz.euler.utils.CollectionUtil;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.github.speisz.euler.utils.CollectionUtil.hashMapOf;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.rangeClosed;

public class ProperDivisors {
    public static Set<Integer> of(int n) {
        return ProperDivisors.of(valueOf(n))
                .stream()
                .map(BigInteger::intValue)
                .collect(toSet());
    }

    public static Set<BigInteger> of(BigInteger n) {
        List<Map<BigInteger, Integer>> factorsAsFactorizations = PrimeFactorization.of(n).entrySet().stream()
                .map(ProperDivisors::getDivisors)
                .reduce(CollectionUtil::crossMergeMaps)
                .orElse(emptyList());
        return factorsAsFactorizations.stream()
                .map(ProperDivisors::computeNumber)
                .filter(m -> !n.equals(m))
                .collect(toSet());
    }

    private static List<Map<BigInteger, Integer>> getDivisors(Map.Entry<BigInteger, Integer> factorization) {
        return rangeClosed(0, factorization.getValue())
                .mapToObj(m -> hashMapOf(factorization.getKey(), m))
                .collect(toList());
    }

    private static BigInteger computeNumber(Map<BigInteger, Integer> factorization) {
        return factorization.entrySet().stream()
                .map(entry -> entry.getKey().pow(entry.getValue()))
                .reduce(BigInteger::multiply)
                .orElse(ONE);
    }
}
