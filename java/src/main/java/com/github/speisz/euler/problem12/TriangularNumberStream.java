package com.github.speisz.euler.problem12;

import com.github.speisz.euler.utils.Pair;

import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;

public class TriangularNumberStream implements Supplier<Stream<BigInteger>> {
    @Override
    public Stream<BigInteger> get() {
        return Stream.iterate(Pair.of(ONE, ONE), this::nextTriangularNumber)
                .map(Pair::second);
    }

    private Pair<BigInteger> nextTriangularNumber(Pair<BigInteger> triangularNumber) {
        BigInteger currentSequentialNumber = triangularNumber.first.add(ONE);
        return Pair.of(currentSequentialNumber, triangularNumber.second.add(currentSequentialNumber));
    }
}
