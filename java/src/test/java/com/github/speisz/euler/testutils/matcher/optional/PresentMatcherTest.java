package com.github.speisz.euler.testutils.matcher.optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Optional;

import static com.github.speisz.euler.testutils.matcher.optional.PresentMatcher.present;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class PresentMatcherTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void checksIfOptionalIsPresent() {
        assertThat(Optional.of("present"), is(present()));
    }

    @Test
    public void hasAppropriateAssertionErrorMessageIfPresentThoughExpectedNotPresent() {
        exception.expect(AssertionError.class);
        exception.expectMessage("not a non-empty optional");

        assertThat(Optional.of("present"), is(not(present())));
    }

    @Test
    public void hasAppropriateAssertionErrorMessageIfNotPresentThoughExpectedPresent() {
        exception.expect(AssertionError.class);
        exception.expectMessage("an empty optional");

        assertThat(Optional.empty(), is(present()));
    }
}