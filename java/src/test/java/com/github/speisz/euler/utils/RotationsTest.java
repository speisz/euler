package com.github.speisz.euler.utils;

import org.junit.Test;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class RotationsTest {

    @Test
    public void streamsRotationsOfGivenString() {
        assertThat(Rotations.stream("abc").collect(toList()), contains("abc", "bca", "cab"));
    }

    @Test
    public void streamsRotationsOfGivenInteger() {
        assertThat(Rotations.stream(123).collect(toList()), contains(123, 231, 312));
    }
}
