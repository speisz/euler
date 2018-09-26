package com.github.speisz.euler.stream;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class BigIntegerStream {
    private BigIntegerStream() {
        // hide default
    }

    public static Stream<BigInteger> range(int startInclusive, int endExclusive) {
        return IntStream.range(startInclusive, endExclusive).mapToObj(BigInteger::valueOf);
    }
}
