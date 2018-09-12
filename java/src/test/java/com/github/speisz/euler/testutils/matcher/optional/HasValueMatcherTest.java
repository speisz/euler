package com.github.speisz.euler.testutils.matcher.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.github.speisz.euler.testutils.matcher.optional.HasValueMatcher.hasValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HasValueMatcherTest {

    @Test
    void checksIfOptionalHasValue() {
        assertThat(Optional.of("value"), hasValue("value"));
    }

    @Test
    void checksIfOptionalHasValueMatchingCondition() {
        assertThat(Optional.of("value"), hasValue(startsWith("val")));
        assertThat(Optional.of("value"), hasValue(equalToIgnoringCase("VALUE")));
    }

    @Test
    void hasAppropriateAssertionErrorMessageIfActualIsEmpty() {
        AssertionError thrownException = assertThrows(AssertionError.class, () -> assertThat(Optional.empty(), hasValue("expectedValue")));

        assertThat(thrownException.getMessage(), both(
                containsString("empty")).and(
                containsString("is \"expectedValue\"")));
    }

    @Test
    void hasAppropriateAssertionErrorMessageIfOptionalHasNotExpectedValue() {
        AssertionError thrownException = assertThrows(AssertionError.class, () -> assertThat(Optional.of("actualValue"), hasValue("expectedValue")));

        assertThat(thrownException.getMessage(), both(
                containsString("actualValue")).and(
                containsString("is \"expectedValue\"")));
    }

    @Test
    void hasAppropriateAssertionErrorMessageIfOptionalHasNotValueWithCondition() {
        AssertionError thrownException = assertThrows(AssertionError.class, () -> assertThat(Optional.of("actualValue"), hasValue(startsWith("expected"))));

        assertThat(thrownException.getMessage(), both(
                containsString("actualValue")).and(
                containsString("starting with \"expected\"")));
    }
}