package com.github.speisz.euler.problem21;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {

    @Test
    public void sumsUpAmicableNumbersUpTo10000() {
        assertThat(AmicableNumberFinder.create().streamUpTo(10000).sum(), is(31626));
    }
}
