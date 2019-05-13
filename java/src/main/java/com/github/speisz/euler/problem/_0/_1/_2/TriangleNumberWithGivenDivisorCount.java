package com.github.speisz.euler.problem._0._1._2;

import com.github.speisz.euler.math.polygonal.Polygonals;

import java.math.BigInteger;

import static com.github.speisz.euler.stream.LongStreams.sequence;

public class TriangleNumberWithGivenDivisorCount {

    public static long compute(int divisorCount) {
        return sequence().map(Polygonals::triangle)
                .filter(n -> DivisorCount.of(BigInteger.valueOf(n)) >= divisorCount)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Did not find any triangle number with divisor count " + divisorCount));
    }
}
