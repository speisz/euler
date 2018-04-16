package com.github.speisz.euler.problem25;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.math.BigInteger;

import static com.github.speisz.euler.testutils.matcher.OptionalMatchers.hasValue;
import static com.github.speisz.euler.utils.Fibonacci.indexedFibonaccis;
import static com.github.speisz.euler.utils.MathUtil.greaterOrEqual;
import static org.hamcrest.MatcherAssert.assertThat;

public class Solution {
    @Test
    public void findsIndexOfFirstFibonacciWith1000Digits() {
        assertThat(indexedFibonaccis()
                .filter(pair -> greaterOrEqual(pair.getRight(), BigInteger.valueOf(10).pow(1000 - 1)))
                .findFirst()
                .map(Pair::getLeft), hasValue(4782));
    }
}
