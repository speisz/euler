package com.github.speisz.euler.math;

import static com.github.speisz.euler.utils.MathUtil.lastDigits;

public class LastDigitsOfProduct {
    private final long firstFactor;
    private final long secondFactor;

    public LastDigitsOfProduct(long firstFactor, long secondFactor) {
        this.firstFactor = firstFactor;
        this.secondFactor = secondFactor;
    }

    public static LastDigitsOfProduct product(long firstFactor, long secondFactor) {
        return new LastDigitsOfProduct(firstFactor, secondFactor);
    }

    public long computeLastDigits(int digitCount) {
        return lastDigits(lastDigits(firstFactor, digitCount) * lastDigits(secondFactor, digitCount), digitCount);
    }
}
