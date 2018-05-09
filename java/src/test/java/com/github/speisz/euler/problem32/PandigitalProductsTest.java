package com.github.speisz.euler.problem32;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PandigitalProductsTest {

    @Test
    public void findsAllPandigitalProducts() {
        assertTrue(PandigitalProducts.stream().anyMatch(n -> n == 7254));
    }
}
