package com.github.speisz.euler.problem29;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {

    @Test
    public void findsNumberOfDistinctPowers() {
        assertThat(DistinctPowersCount.of(5,5), is(15L));
        assertThat(DistinctPowersCount.of(100,100), is(9183L));
    }
}
