package com.github.speisz.euler.testutils.matcher.optionallong;

import org.junit.jupiter.api.Test;

import java.util.OptionalLong;

import static com.github.speisz.euler.testutils.matcher.optionallong.PresentMatcher.present;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PresentMatcherTest {

    @Test
    void checksIfOptionalIsPresent() {
        assertThat(OptionalLong.of(1L), is(present()));
    }

    @Test
    void hasAppropriateAssertionErrorMessageIfPresentThoughExpectedNotPresent() {
        AssertionError thrownException = assertThrows(AssertionError.class, () -> assertThat(OptionalLong.of(1L), is(not(present()))));

        assertThat(thrownException.getMessage(), containsString("not a non-empty optional"));
    }

    @Test
    void hasAppropriateAssertionErrorMessageIfNotPresentThoughExpectedPresent() {
        AssertionError thrownException = assertThrows(AssertionError.class, () -> assertThat(OptionalLong.empty(), is(present())));

        assertThat(thrownException.getMessage(), containsString("an empty optional"));
    }
}
