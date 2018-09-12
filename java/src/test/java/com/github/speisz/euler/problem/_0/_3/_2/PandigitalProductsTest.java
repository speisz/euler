package com.github.speisz.euler.problem._0._3._2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PandigitalProductsTest {

    @Test
    void findsAllPandigitalProducts() {
        assertTrue(PandigitalProducts.stream().anyMatch(n -> n == 7254));
    }
}
