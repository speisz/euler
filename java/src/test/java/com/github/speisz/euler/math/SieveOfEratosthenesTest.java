package com.github.speisz.euler.math;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SieveOfEratosthenesTest {

//    public ExpectedException exception = ExpectedException.none();
    
    @Test
    public void testsIfNumberIsPrime() {
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes(10);

        assertTrue(sieveOfEratosthenes.test(2));
        assertTrue(sieveOfEratosthenes.test(3));
        assertTrue(sieveOfEratosthenes.test(5));
        assertTrue(sieveOfEratosthenes.test(7));

        assertFalse(sieveOfEratosthenes.test(4));
        assertFalse(sieveOfEratosthenes.test(6));
        assertFalse(sieveOfEratosthenes.test(8));
        assertFalse(sieveOfEratosthenes.test(9));
        assertFalse(sieveOfEratosthenes.test(10));
        
        assertFalse(sieveOfEratosthenes.test(1));
        assertFalse(sieveOfEratosthenes.test(0));
        assertFalse(sieveOfEratosthenes.test(-1));
        assertFalse(sieveOfEratosthenes.test(-3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfNumberToTestIsOutOfRange() {
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes(10);

//        exception.expect(IllegalArgumentException.class);
//        exception.expectMessage("11");

        sieveOfEratosthenes.test(11);
    }
}
