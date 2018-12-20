package com.github.speisz.euler.utils;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class IntUtilTest {

    @Test
    void concatsIntegerStream() {
        assertThat(IntUtil.concat(rangeClosed(20, 22).boxed()), is(202122));
    }

    @Test
    void concatsIntegerArray() {
        assertThat(IntUtil.concat(1, 23), is(123));
    }

    @Test
    void concatsIntegerCollection() {
        assertThat(IntUtil.concat(asList(20, 31)), is(2031));
    }
}