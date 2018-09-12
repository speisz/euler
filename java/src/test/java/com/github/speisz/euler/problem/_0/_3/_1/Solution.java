package com.github.speisz.euler.problem._0._3._1;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    @Test
    void findsNumberOfCoinCombinationsOf2Pounds() {
        assertThat(new CoinCombinationsFinder(200, 100, 50, 20, 10, 5, 2, 1).findAllFor(200).size(), is(73682));
    }
}
