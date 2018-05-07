package com.github.speisz.euler.problem30;

import com.github.speisz.euler.utils.MathUtil;

import java.util.function.LongPredicate;

import static com.github.speisz.euler.utils.MathUtil.digits;

public class EqualsPowerDigitSum implements LongPredicate {

    private int exponent;

    @Override
    public boolean test(long number) {
        int sum = digits(number)
                .map(n -> MathUtil.pow(n, exponent))
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
