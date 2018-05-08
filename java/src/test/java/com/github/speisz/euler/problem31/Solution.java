package com.github.speisz.euler.problem31;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {

    @Test
    public void findsNumberOfCoinCombinationsOf2Pounds() {
        assertThat(new CoinCombinationsFinder(200, 100, 50, 20, 10, 5, 2, 1).findAllFor(200).size(), is(73682));
    }
}
