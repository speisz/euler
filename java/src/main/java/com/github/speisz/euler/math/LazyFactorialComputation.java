package com.github.speisz.euler.math;

import com.google.common.collect.ImmutableMap;

import java.math.BigInteger;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;
import static java.math.BigInteger.ONE;

public class LazyFactorialComputation {
    private Map<Integer, BigInteger> factorials;

    public LazyFactorialComputation() {
        factorials = newHashMap(ImmutableMap.of(0, ONE));
    }

    public BigInteger of(int n) {
        if (!factorials.containsKey(n)) {
            factorials.put(n, BigInteger.valueOf(n).multiply(this.of(n - 1)));
        }
        return factorials.get(n);
    }
}
