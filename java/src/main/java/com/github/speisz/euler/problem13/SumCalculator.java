package com.github.speisz.euler.problem13;

import java.math.BigInteger;
import java.util.stream.Stream;

public class SumCalculator {

    private BigInteger[] summands;

    public static SumCalculator ofSummands(BigInteger... summands) {
        return new SumCalculator(summands);
    }

    private SumCalculator(BigInteger... summands) {
        this.summands = summands;
    }

    public BigInteger getSum() {
        return Stream.of(summands).reduce(BigInteger.ZERO, BigInteger::add);
    }

    public BigInteger getFirstDigitsOfSum(int digitCount) {
        if (digitCount < 1) {
            return BigInteger.ZERO;
        }
        return new BigInteger(getSum().toString().substring(0, digitCount));
    }
}
