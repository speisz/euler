package com.github.speisz.euler.utils;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class IntUtilTest {

    @Test
    public void concatsIntegers() {
        assertThat(IntUtil.concat(1,23), is(123));
    }
}