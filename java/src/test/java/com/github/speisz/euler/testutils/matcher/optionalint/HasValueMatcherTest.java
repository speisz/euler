package com.github.speisz.euler.testutils.matcher.optionalint;

import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static com.github.speisz.euler.testutils.matcher.optionalint.HasValueMatcher.hasValue;
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
        assertThat(OptionalInt.of(1), hasValue(1));
    }

    @Test
    void checksIfOptionalHasValueMatchingCondition() {
        assertThat(OptionalInt.of(1), hasValue(greaterThan(0)));
        assertThat(OptionalInt.of(1), hasValue(not(equalTo(0))));
    }

    @Test
    void hasAppropriateAssertionErrorMessageIfActualIsEmpty() {
        AssertionError thrownError = assertThrows(AssertionError.class, () -> assertThat(OptionalInt.empty(), hasValue(1)));
        assertThat(thrownError.getMessage(), both(
                containsString("is <1>")).and(
                containsString("empty")));
    }

    @Test
    void hasAppropriateAssertionErrorMessageIfOptionalHasNotExpectedValue() {
        AssertionError thrownError = assertThrows(AssertionError.class, () -> assertThat(OptionalInt.of(0), hasValue(1)));
        assertThat(thrownError.getMessage(), both(
                containsString("is <1>")).and(
                containsString("0")));
    }

    @Test
    void hasAppropriateAssertionErrorMessageIfOptionalHasNotValueWithCondition() {
        AssertionError thrownError = assertThrows(AssertionError.class, () -> assertThat(OptionalInt.of(1), hasValue(greaterThan(2))));
        assertThat(thrownError.getMessage(), both(
                containsString("greater than <2>")).and(
                containsString("1")));
    }
}
