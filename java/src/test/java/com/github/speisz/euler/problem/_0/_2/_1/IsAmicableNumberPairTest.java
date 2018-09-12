package com.github.speisz.euler.problem._0._2._1;

import org.junit.jupiter.api.Test;

import static java.math.BigInteger.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class IsAmicableNumberPairTest {
    @Test
    void testsIfNumbersAreAmicablePair() {
        assertThat(new IsAmicableNumberPair().test(valueOf(220), valueOf(284)), is(true));
    }
}
