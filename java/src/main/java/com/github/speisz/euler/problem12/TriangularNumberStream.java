package com.github.speisz.euler.problem12;

import org.apache.commons.lang3.tuple.Pair;

import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;

public class TriangularNumberStream implements Supplier<Stream<BigInteger>> {
    @Override
    public Stream<BigInteger> get() {
        return Stream.iterate(Pair.of(ONE, ONE), this::nextTriangularNumber)
                .map(Pair::getRight);
    }

    private Pair<BigInteger, BigInteger> nextTriangularNumber(Pair<BigInteger, BigInteger> triangularNumber) {
        BigInteger currentSequentialNumber = triangularNumber.getLeft().add(ONE);
        return Pair.of(currentSequentialNumber, triangularNumber.getRight().add(currentSequentialNumber));
    }
}
