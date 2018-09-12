package com.github.speisz.euler.problem._0._5._0;

import org.junit.jupiter.api.Test;

import static com.github.speisz.euler.problem._0._5._0.LongestChainsOfConsecutivePrimesAddingToAPrimeFinder.createLongestChainsOfConsecutivePrimesAddingToAPrimeFinder;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    @Test
    void findsLongestChainsOfConsecutivePrimesAddingToAPrime() {
        assertThat(createLongestChainsOfConsecutivePrimesAddingToAPrimeFinder(100).find().getSum(), is(41));
        assertThat(createLongestChainsOfConsecutivePrimesAddingToAPrimeFinder(1_000).find().getSum(), is(953));
        assertThat(createLongestChainsOfConsecutivePrimesAddingToAPrimeFinder(1_000_000).find(21).getSum(), is(997651));
    }
}
