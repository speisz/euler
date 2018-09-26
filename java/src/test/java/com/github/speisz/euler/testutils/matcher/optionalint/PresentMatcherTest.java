package com.github.speisz.euler.testutils.matcher.optionalint;

import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static com.github.speisz.euler.testutils.matcher.optionalint.PresentMatcher.present;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PresentMatcherTest {

    @Test
    void checksIfOptionalIsPresent() {
        assertThat(OptionalInt.of(1), is(present()));
    }

    @Test
    void hasAppropriateAssertionErrorMessageIfPresentThoughExpectedNotPresent() {
        AssertionError thrownException = assertThrows(AssertionError.class, () -> assertThat(OptionalInt.of(1), is(not(present()))));

        assertThat(thrownException.getMessage(), containsString("not a non-empty optional"));
    }

    @Test
    void hasAppropriateAssertionErrorMessageIfNotPresentThoughExpectedPresent() {
        AssertionError thrownException = assertThrows(AssertionError.class, () -> assertThat(OptionalInt.empty(), is(present())));

        assertThat(thrownException.getMessage(), containsString("an empty optional"));
    }
}
