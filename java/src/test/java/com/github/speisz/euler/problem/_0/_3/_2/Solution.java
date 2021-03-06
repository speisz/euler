package com.github.speisz.euler.problem._0._3._2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    @Test
    void findsTheSumOfAllPandigitalProducts() {
        assertThat(PandigitalProducts.stream().mapToInt(n -> n).sum(), is(45228));
    }
}
