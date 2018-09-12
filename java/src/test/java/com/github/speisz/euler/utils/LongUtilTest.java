package com.github.speisz.euler.utils;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LongUtilTest {

    @Test
    void concatsLongs() {
        assertThat(LongUtil.concat(1, 23), is(123L));
    }
}
