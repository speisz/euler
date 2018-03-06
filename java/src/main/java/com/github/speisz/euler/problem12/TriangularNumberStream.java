package com.github.speisz.euler.problem12;

import com.github.speisz.euler.utils.Tuple;

import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;

public class TriangularNumberStream implements Supplier<Stream<BigInteger>> {
    @Override
    public Stream<BigInteger> get() {
        return Stream.iterate(Tuple.of(ONE, ONE), this::nextTriangularNumber)
                .map(Tuple::second);
    }

    private Tuple<BigInteger> nextTriangularNumber(Tuple<BigInteger> triangularNumber) {
        BigInteger currentSequentialNumber = triangularNumber.first.add(ONE);
        return Tuple.of(currentSequentialNumber, triangularNumber.second.add(currentSequentialNumber));
    }
}
