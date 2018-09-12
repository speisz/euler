package com.github.speisz.euler.problem14;

import java.math.BigInteger;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.github.speisz.euler.utils.MathUtil.TWO;
import static com.github.speisz.euler.utils.MathUtil.isEven;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;

public class CollatzChain {
    private BigInteger seed;

    private CollatzChain(BigInteger seed) {
        this.seed = seed;
    }

    public static CollatzChain of(BigInteger seed) {
        return new CollatzChain(seed);
    }

    public Stream<BigInteger> get() {
        return Sequence.<BigInteger>builder()
                .withSeed(seed)
                .withCondition(((Predicate<BigInteger>) ONE::equals).negate())
                .withRule(this::nextNumberInCollatzSequence)
                .build()
                .compute();
    }

    private BigInteger nextNumberInCollatzSequence(BigInteger n) {
        if (isEven(n)) {
            return n.divide(TWO);
        }
        return n.multiply(valueOf(3)).add(ONE);
    }
}
