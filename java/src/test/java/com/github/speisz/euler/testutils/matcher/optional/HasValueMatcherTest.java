package com.github.speisz.euler.testutils.matcher.optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Optional;

import static com.github.speisz.euler.testutils.matcher.optional.HasValueMatcher.hasValue;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;

public class HasValueMatcherTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void checksIfOptionalHasValue() {
        assertThat(Optional.of("value"), hasValue("value"));
    }

    @Test
    public void checksIfOptionalHasValueMatchingCondition() {
        assertThat(Optional.of("value"), hasValue(startsWith("val")));
        assertThat(Optional.of("value"), hasValue(equalToIgnoringCase("VALUE")));
    }

    @Test
    public void hasAppropriateAssertionErrorMessageIfActualIsEmpty() {
        exception.expect(AssertionError.class);
        exception.expectMessage("is \"expectedValue\"");
        exception.expectMessage("empty");

        assertThat(Optional.empty(), hasValue("expectedValue"));
    }

    @Test
    public void hasAppropriateAssertionErrorMessageIfOptionalHasNotExpectedValue() {
        exception.expect(AssertionError.class);
        exception.expectMessage("is \"expectedValue\"");
        exception.expectMessage("actualValue");

        assertThat(Optional.of("actualValue"), hasValue("expectedValue"));
    }

    @Test
    public void hasAppropriateAssertionErrorMessageIfOptionalHasNotValueWithCondition() {
        exception.expect(AssertionError.class);
        exception.expectMessage("starting with \"expected\"");
        exception.expectMessage("actualValue");

        assertThat(Optional.of("actualValue"), hasValue(startsWith("expected")));
    }
}