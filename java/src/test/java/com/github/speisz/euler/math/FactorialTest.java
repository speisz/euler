package com.github.speisz.euler.math;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {
    
    @Test
    void computesBigIntegerFactorials() {
        assertThat(Factorial.of(0), is(BigInteger.ONE));
        assertThat(Factorial.of(1), is(BigInteger.ONE));
        assertThat(Factorial.of(2), is(BigInteger.valueOf(2)));
        assertThat(Factorial.of(3), is(BigInteger.valueOf(3 * 2)));
        assertThat(Factorial.of(4), is(BigInteger.valueOf(4 * 3 * 2)));
        assertThat(Factorial.of(5), is(BigInteger.valueOf(5 * 4 * 3 * 2)));
        assertThat(Factorial.of(10), is(BigInteger.valueOf(3628800)));
    }
    
    @Test
    void computesIntegerFactorials() {
        assertThat(Factorial.asIntegerOf(0), is(1));
        assertThat(Factorial.asIntegerOf(1), is(1));
        assertThat(Factorial.asIntegerOf(2), is(2));
        assertThat(Factorial.asIntegerOf(3), is(3 * 2));
        assertThat(Factorial.asIntegerOf(4), is(4 * 3 * 2));
        assertThat(Factorial.asIntegerOf(5), is(5 * 4 * 3 * 2));
        assertThat(Factorial.asIntegerOf(10),is(3628800));
        
        assertThrows(IllegalArgumentException.class, () -> Factorial.asIntegerOf(20));
    }
}
