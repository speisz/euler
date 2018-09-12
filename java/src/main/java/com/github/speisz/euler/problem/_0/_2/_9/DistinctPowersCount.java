package com.github.speisz.euler.problem._0._2._9;

import java.math.BigInteger;

import static com.github.speisz.euler.utils.StreamUtil.pairStream;
import static java.util.stream.IntStream.rangeClosed;

public class DistinctPowersCount {
    public static long of(int upperBase, int upperExponent) {
        return pairStream(() -> rangeClosed(2, upperBase).mapToObj(BigInteger::valueOf), () -> rangeClosed(2, upperExponent).boxed())
                .map(baseAndExponent -> baseAndExponent.getLeft().pow(baseAndExponent.getRight()))
                .distinct()
                .count();
    }
}
