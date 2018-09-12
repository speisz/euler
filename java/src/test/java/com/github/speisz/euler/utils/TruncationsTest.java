package com.github.speisz.euler.utils;

import org.junit.jupiter.api.Test;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

class TruncationsTest {

    @Test
    void streamsAllTruncationsOfGivenString() {
        assertThat(Truncations.stream("").collect(toList()), is(empty()));
        assertThat(Truncations.stream("a").collect(toList()), is(empty()));
        assertThat(Truncations.stream("ab").collect(toList()), contains("b", "a"));
        assertThat(Truncations.stream("abc").collect(toList()), contains("bc", "c", "ab", "a"));
    }

    @Test
    void streamsAllTruncationsOfGivenLong() {
        assertThat(Truncations.stream(1L).collect(toList()), is(empty()));
        assertThat(Truncations.stream(12L).collect(toList()), contains(2L, 1L));
        assertThat(Truncations.stream(123L).collect(toList()), contains(23L, 3L, 12L, 1L));
    }

    @Test
    void streamsAllTruncationsOfGivenInteger() {
        assertThat(Truncations.stream(1).collect(toList()), is(empty()));
        assertThat(Truncations.stream(12).collect(toList()), contains(2, 1));
        assertThat(Truncations.stream(123).collect(toList()), contains(23, 3, 12, 1));
        assertThat(Truncations.stream(Integer.MAX_VALUE).collect(toList()), contains(147483647, 47483647, 7483647, 483647, 83647, 3647, 647, 47, 7, 214748364, 21474836, 2147483, 214748, 21474, 2147, 214, 21, 2));
    }
}
