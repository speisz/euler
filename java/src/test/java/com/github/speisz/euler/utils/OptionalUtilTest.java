package com.github.speisz.euler.utils;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.github.speisz.euler.testutils.matcher.OptionalMatchers.hasValue;
import static com.github.speisz.euler.utils.OptionalUtil.firstNonEmpty;
import static org.hamcrest.MatcherAssert.assertThat;

class OptionalUtilTest {

    @Test
    void takes2ndIf1stIsEmpty() {
        assertThat(firstNonEmpty(Optional.empty(), Optional.of("second")), hasValue("second"));
    }

    @Test
    void takes3rdIf1stAnd2ndIsEmpty() {
        assertThat(firstNonEmpty(Optional.empty(), Optional.empty(), Optional.of("third")), hasValue("third"));
    }
}