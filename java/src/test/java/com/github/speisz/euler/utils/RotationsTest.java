package com.github.speisz.euler.utils;

import org.junit.jupiter.api.Test;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class RotationsTest {

    @Test
    void streamsRotationsOfGivenString() {
        assertThat(Rotations.stream("abc").collect(toList()), contains("abc", "bca", "cab"));
    }

    @Test
    void streamsRotationsOfGivenInteger() {
        assertThat(Rotations.stream(123).collect(toList()), contains(123, 231, 312));
    }
}
