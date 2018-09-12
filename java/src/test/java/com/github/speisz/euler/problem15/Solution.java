package com.github.speisz.euler.problem15;

import com.github.speisz.euler.utils.BinomialCoefficient;
import org.junit.jupiter.api.Test;

import static java.math.BigInteger.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {
    @Test
    void numberOfWaysIn20x20Grid() {
        assertThat(BinomialCoefficient.of(40, 20), is(valueOf(137846528820L)));
    }
}
