package com.github.speisz.euler.math;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LastDigitsOfProductTest {

    @Test
    void computesLastDigitsOfProduct() {
        assertThat(LastDigitsOfProduct.product(1234, 567).computeLastDigits(2), is(78L));
    }
}
