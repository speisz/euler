package com.github.speisz.euler.problem50;

import org.junit.Test;

import static com.github.speisz.euler.problem50.LongestChainsOfConsecutivePrimesAddingToAPrimeFinder.createLongestChainsOfConsecutivePrimesAddingToAPrimeFinder;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {

    @Test
    public void findsLongestChainsOfConsecutivePrimesAddingToAPrime() {
        assertThat(createLongestChainsOfConsecutivePrimesAddingToAPrimeFinder(100).find().getSum(), is(41));
        assertThat(createLongestChainsOfConsecutivePrimesAddingToAPrimeFinder(1_000).find().getSum(), is(953));
        assertThat(createLongestChainsOfConsecutivePrimesAddingToAPrimeFinder(1_000_000).find(21).getSum(), is(997651));
    }
}
