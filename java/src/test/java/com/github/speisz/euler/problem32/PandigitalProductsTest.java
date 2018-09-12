package com.github.speisz.euler.problem32;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PandigitalProductsTest {

    @Test
    void findsAllPandigitalProducts() {
        assertTrue(PandigitalProducts.stream().anyMatch(n -> n == 7254));
    }
}
