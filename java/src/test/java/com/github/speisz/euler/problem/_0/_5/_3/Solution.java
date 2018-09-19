package com.github.speisz.euler.problem._0._5._3;

import com.github.speisz.euler.utils.BinomialCoefficient;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static com.github.speisz.euler.utils.BinaryMinSearch.binarySearchForMin;
import static com.github.speisz.euler.utils.MathUtil.greaterThan;
import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    static final BigInteger ONE_MILLION = BigInteger.valueOf(1_000_000L);

    @Test
    void findsNumberOfBinomialCoefficientsGreaterThanOneMillion() {
        assertThat(rangeClosed(23, 100)
                .map(this::countBinomialGreaterThanOneMillion)
                .sum(), is(4075));
    }

    int countBinomialGreaterThanOneMillion(int n) {
        return binarySearchForMin(r -> greaterThan(BinomialCoefficient.of(n, r), ONE_MILLION), 0, n / 2)
                .map(r -> countNumbers(r, n - r))
                .orElse(0);
    }

    int countNumbers(int lower, int upper) {
        return upper - lower + 1;
    }
}
