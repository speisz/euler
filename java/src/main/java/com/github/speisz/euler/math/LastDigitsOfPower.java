package com.github.speisz.euler.math;

import static com.github.speisz.euler.math.LastDigitsOfProduct.product;
import static java.util.stream.IntStream.generate;

public class LastDigitsOfPower {
    private final int base;
    private final int exponent;

    public LastDigitsOfPower(int base, int exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    public static LastDigitsOfPower pow(int base, int exponent) {
        return new LastDigitsOfPower(base, exponent);
    }

    public long computeLastDigits(int digitCount) {
        return generate(() -> base)
                .limit(exponent)
                .mapToLong(n -> n)
                .reduce(1, (n, m) -> product(n, m).computeLastDigits(digitCount));
    }
}
