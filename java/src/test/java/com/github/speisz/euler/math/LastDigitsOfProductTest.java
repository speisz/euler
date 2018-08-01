package com.github.speisz.euler.math;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LastDigitsOfProductTest {

    @Test
    public void computesLastDigitsOfProduct() {
        assertThat(LastDigitsOfProduct.product(1234, 567).computeLastDigits(2), is(78L));
    }
}
