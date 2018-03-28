package com.github.speisz.euler.problem21;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

public class ProperDivisorsTest {
    @Test
    public void findsProperDivisorsOfIntegers() {
        assertThat(ProperDivisors.of(1), is(empty()));
        assertThat(ProperDivisors.of(2), containsInAnyOrder(1));
        assertThat(ProperDivisors.of(3), containsInAnyOrder(1));
        assertThat(ProperDivisors.of(4), containsInAnyOrder(1, 2));
        assertThat(ProperDivisors.of(12), containsInAnyOrder(1, 2, 3, 4, 6));
        assertThat(ProperDivisors.of(220), containsInAnyOrder(1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110));
        assertThat(ProperDivisors.of(284), containsInAnyOrder(1, 2, 4, 71, 142));
    }
}
