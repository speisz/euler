package com.github.speisz.euler.utils;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class IntUtilTest {

    @Test
    void concatsIntegers() {
        assertThat(IntUtil.concat(1, 23), is(123));
    }
}