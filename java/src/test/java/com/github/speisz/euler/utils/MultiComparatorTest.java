package com.github.speisz.euler.utils;

import org.apache.commons.collections4.comparators.ComparatorChain;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparingInt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class MultiComparatorTest {

    @Test
    void comparesUsingTheProvidedComparators() {
        MultiComparator<String> multiComparator = new MultiComparator<>(
                comparingInt(s -> s.indexOf('1')),
                comparingInt(s -> s.indexOf('2')));

        assertThat(multiComparator.compare("2xx1x", "x21xx"), is(1));
        assertThat(multiComparator.compare("1xx2x", "x12xx"), is(-1));
        assertThat(multiComparator.compare("x2x1x", "2xx1x"), is(1));
        assertThat(multiComparator.compare("2xx1x", "x2x1x"), is(-1));
        assertThat(multiComparator.compare("x2xx1x", "z2xx1x"), is(0));
    }
}