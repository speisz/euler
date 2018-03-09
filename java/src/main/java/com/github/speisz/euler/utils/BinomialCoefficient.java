package com.github.speisz.euler.utils;

import java.math.BigInteger;

public abstract class BinomialCoefficient {
    public static BigInteger of(int n, int k) {
        return Faculty.of(n).divide(Faculty.of(k).multiply(Faculty.of(n - k)));
    }

    private BinomialCoefficient() {
    }
}
