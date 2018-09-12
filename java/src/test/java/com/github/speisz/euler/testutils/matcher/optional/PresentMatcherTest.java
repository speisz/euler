package com.github.speisz.euler.testutils.matcher.optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Optional;

import static com.github.speisz.euler.testutils.matcher.optional.PresentMatcher.present;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PresentMatcherTest {

    @Test
    void checksIfOptionalIsPresent() {
        assertThat(Optional.of("present"), is(present()));
    }

    @Test
    void hasAppropriateAssertionErrorMessageIfPresentThoughExpectedNotPresent() {
        Executable falseAssertion = () -> assertThat(Optional.of("present"), is(not(present())));
        AssertionError thrownException = assertThrows(AssertionError.class, falseAssertion);
        assertThat(thrownException.getMessage(), containsString("not a non-empty optional"));
    }

    @Test
    void hasAppropriateAssertionErrorMessageIfNotPresentThoughExpectedPresent() {
        Executable falseAssertion = () -> assertThat(Optional.empty(), is(present()));
        AssertionError thrownException = assertThrows(AssertionError.class, falseAssertion);
        assertThat(thrownException.getMessage(), containsString("an empty optional"));
    }
}
