package com.github.speisz.euler.utils;

import org.junit.Test;

import java.util.Optional;

import static com.github.speisz.euler.testutils.matcher.OptionalMatchers.hasValue;
import static com.github.speisz.euler.utils.OptionalUtil.firstNonEmpty;
import static org.junit.Assert.assertThat;

public class OptionalUtilTest {
    
    @Test
    public void takes2ndIf1stIsEmpty() {
        assertThat(firstNonEmpty(Optional.empty(), Optional.of("second")), hasValue("second"));
    }

    @Test
    public void takes3rdIf1stAnd2ndIsEmpty() {
        assertThat(firstNonEmpty(Optional.empty(), Optional.empty(), Optional.of("third")), hasValue("third"));
    }
}