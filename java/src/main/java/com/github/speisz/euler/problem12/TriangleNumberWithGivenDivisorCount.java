package com.github.speisz.euler.problem12;

import java.math.BigInteger;

public class TriangleNumberWithGivenDivisorCount {

    private TriangularNumberStream triangularNumberStream;

    TriangleNumberWithGivenDivisorCount() {
        triangularNumberStream = new TriangularNumberStream();
    }

    public BigInteger compute(int divisorCount) {
        return triangularNumberStream.get()
                .filter(n -> DivisorCount.of(n) >= divisorCount)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Did not find any triangular number with divisor count " + divisorCount));
    }
}
