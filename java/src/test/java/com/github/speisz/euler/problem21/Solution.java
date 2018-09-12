package com.github.speisz.euler.problem21;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    @Test
    void sumsUpAmicableNumbersUpTo10000() {
        assertThat(AmicableNumberFinder.create().streamUpTo(10000).sum(), is(31626));
    }
}
