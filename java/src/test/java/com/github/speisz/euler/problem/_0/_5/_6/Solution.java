package com.github.speisz.euler.problem._0._5._6;

import com.github.speisz.euler.stream.BigIntegerStream;
import com.github.speisz.euler.utils.MathUtil;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.github.speisz.euler.testutils.matcher.optionalint.HasValueMatcher.hasValue;
import static org.hamcrest.MatcherAssert.assertThat;

class Solution {

    @Test
    void findsMaximumDigitSumOfPowersWithBaseExponentLowerThan100() {
        assertThat(BigIntegerStream.range(2, 100)
                .flatMap(this::powers)
                .map(MathUtil::digits)
                .mapToInt(IntStream::sum)
                .max(), hasValue(972));
    }

    Stream<BigInteger> powers(BigInteger base) {
        return IntStream.range(2, 100).boxed().map(base::pow);
    }
}
