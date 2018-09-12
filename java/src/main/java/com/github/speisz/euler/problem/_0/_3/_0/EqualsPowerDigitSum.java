package com.github.speisz.euler.problem._0._3._0;

import java.util.function.LongPredicate;

import static com.github.speisz.euler.utils.MathUtil.digits;
import static com.github.speisz.euler.utils.MathUtil.pow;

public class EqualsPowerDigitSum implements LongPredicate {

    private int exponent;

    @Override
    public boolean test(long number) {
        int sum = digits(number)
                .map(n -> (int) pow(n, exponent))
                .sum();
        return number == sum;
    }

    private EqualsPowerDigitSum(int exponent) {
        this.exponent = exponent;
    }

    static EqualsPowerDigitSum forExponent(int exponent) {
        return new EqualsPowerDigitSum(exponent);
    }
}
