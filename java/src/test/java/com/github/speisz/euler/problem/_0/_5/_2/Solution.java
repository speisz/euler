package com.github.speisz.euler.problem._0._5._2;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static com.github.speisz.euler.testutils.matcher.OptionalMatchers.hasValue;
import static com.github.speisz.euler.utils.MathUtil.digits;
import static com.github.speisz.euler.utils.MathUtil.intBase10Pow;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.iterate;
import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;

class Solution {

    private static final int MAX_FACTOR = 6;

    @Test
    void findsSmallestIntegerWithMultiplesUpToSixContainSameDigits() {
        assertThat(iterate(1, exponent -> exponent + 1)
                .flatMap(this::currentExponentRange)
                .filter(this::multiplesContainSameDigits)
                .boxed().findFirst(), hasValue(142_857));
    }

    private IntStream currentExponentRange(int exponent) {
        return range(intBase10Pow(exponent), intBase10Pow(exponent + 1) / MAX_FACTOR);
    }

    private boolean multiplesContainSameDigits(int number) {
        List<Integer> digits = sortedDigitList(number);
        return rangeClosed(2, MAX_FACTOR)
                .map(factor -> factor * number)
                .mapToObj(this::sortedDigitList)
                .allMatch(digits::equals);
    }

    private List<Integer> sortedDigitList(int number) {
        return digits(number).sorted().boxed().collect(toList());
    }
}
