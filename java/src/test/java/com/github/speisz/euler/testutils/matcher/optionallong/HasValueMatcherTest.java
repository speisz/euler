package com.github.speisz.euler.testutils.matcher.optionallong;

import org.junit.jupiter.api.Test;

import java.util.OptionalLong;

import static com.github.speisz.euler.testutils.matcher.optionallong.HasValueMatcher.hasValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HasValueMatcherTest {

    @Test
    void checksIfOptionalHasValue() {
        assertThat(OptionalLong.of(1L), hasValue(1L));
    }

    @Test
    void checksIfOptionalHasValueMatchingCondition() {
        assertThat(OptionalLong.of(1L), hasValue(greaterThan(0L)));
        assertThat(OptionalLong.of(1L), hasValue(not(equalTo(0L))));
    }

    @Test
    void hasAppropriateAssertionErrorMessageIfActualIsEmpty() {
        AssertionError thrownError = assertThrows(AssertionError.class, () -> assertThat(OptionalLong.empty(), hasValue(1L)));
        assertThat(thrownError.getMessage(), both(
                containsString("is <1L>")).and(
                containsString("empty")));
    }

    @Test
    void hasAppropriateAssertionErrorMessageIfOptionalHasNotExpectedValue() {
        AssertionError thrownError = assertThrows(AssertionError.class, () -> assertThat(OptionalLong.of(0L), hasValue(1L)));
        assertThat(thrownError.getMessage(), both(
                containsString("is <1L>")).and(
                containsString("0")));
    }

    @Test
    void hasAppropriateAssertionErrorMessageIfOptionalHasNotValueWithCondition() {
        AssertionError thrownError = assertThrows(AssertionError.class, () -> assertThat(OptionalLong.of(1L), hasValue(greaterThan(2L))));
        assertThat(thrownError.getMessage(), both(
                containsString("greater than <2L>")).and(
                containsString("1")));
    }
}
