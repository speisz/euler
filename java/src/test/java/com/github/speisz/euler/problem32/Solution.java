package com.github.speisz.euler.problem32;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {

    @Test
    public void findsTheSumOfAllPandigitalProducts() {
        assertThat(PandigitalProducts.stream().mapToInt(n -> n).sum(), is(45228));
    }
}
