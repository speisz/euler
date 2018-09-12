package com.github.speisz.euler.problem._0._3._8;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class ConcatenatedProductTest {

    @Test
    void computesConcatenatedProducts() {
        assertThat(ConcatenatedProduct.of(192, asList(1, 2, 3)), is(192384576L));
        assertThat(ConcatenatedProduct.of(9, asList(1, 2, 3, 4, 5)), is(918273645L));
    }
}
