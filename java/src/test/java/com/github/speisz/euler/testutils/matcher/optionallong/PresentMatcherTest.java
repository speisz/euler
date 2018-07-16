package com.github.speisz.euler.testutils.matcher.optionallong;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Optional;
import java.util.OptionalLong;

import static com.github.speisz.euler.testutils.matcher.optionallong.PresentMatcher.present;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class PresentMatcherTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void checksIfOptionalIsPresent() {
        assertThat(OptionalLong.of(1L), is(present()));
    }

    @Test
    public void hasAppropriateAssertionErrorMessageIfPresentThoughExpectedNotPresent() {
        exception.expect(AssertionError.class);
        exception.expectMessage("not a non-empty optional");

        assertThat(OptionalLong.of(1L), is(not(present())));
    }

    @Test
    public void hasAppropriateAssertionErrorMessageIfNotPresentThoughExpectedPresent() {
        exception.expect(AssertionError.class);
        exception.expectMessage("an empty optional");

        assertThat(OptionalLong.empty(), is(present()));
    }
}
