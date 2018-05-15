package com.github.speisz.euler.utils;

import com.github.speisz.euler.math.Factorial;

import java.math.BigInteger;

public abstract class BinomialCoefficient {
    public static BigInteger of(int n, int k) {
        return Factorial.of(n).divide(Factorial.of(k).multiply(Factorial.of(n - k)));
    }

    private BinomialCoefficient() {
    }
}
