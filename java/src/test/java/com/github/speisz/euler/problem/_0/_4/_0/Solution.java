package com.github.speisz.euler.problem._0._4._0;

import com.github.speisz.euler.utils.MathUtil;
import org.junit.jupiter.api.Test;

import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    @Test
    void findsProductOfSomeDigitsInChampernownesConstant() {
        assertThat(rangeClosed(1, 6)
                .map(this::baseTenPower)
                .map(DigitInChampernownesConstant::find)
                .reduce(1, (n, m) -> n * m), is(210));
    }

    private int baseTenPower(int exponent) {
        return (int) MathUtil.pow(10, exponent);
    }
}
