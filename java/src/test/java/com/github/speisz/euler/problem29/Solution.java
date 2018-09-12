package com.github.speisz.euler.problem29;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    @Test
    void findsNumberOfDistinctPowers() {
        assertThat(DistinctPowersCount.of(5, 5), is(15L));
        assertThat(DistinctPowersCount.of(100, 100), is(9183L));
    }
}
