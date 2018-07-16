package com.github.speisz.euler.testutils.matcher.optionallong;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Optional;
import java.util.OptionalLong;

import static com.github.speisz.euler.testutils.matcher.optionallong.HasValueMatcher.hasValue;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;

public class HasValueMatcherTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void checksIfOptionalHasValue() {
        assertThat(OptionalLong.of(1L), hasValue(1L));
    }

    @Test
    public void checksIfOptionalHasValueMatchingCondition() {
        assertThat(OptionalLong.of(1L), hasValue(greaterThan(0L)));
        assertThat(OptionalLong.of(1L), hasValue(not(equalTo(0L))));
    }

    @Test
    public void hasAppropriateAssertionErrorMessageIfActualIsEmpty() {
        exception.expect(AssertionError.class);
        exception.expectMessage("is <1L>");
        exception.expectMessage("empty");

        assertThat(OptionalLong.empty(), hasValue(1L));
    }

    @Test
    public void hasAppropriateAssertionErrorMessageIfOptionalHasNotExpectedValue() {
        exception.expect(AssertionError.class);
        exception.expectMessage("is <1L>");
        exception.expectMessage("0");

        assertThat(OptionalLong.of(0L), hasValue(1L));
    }

    @Test
    public void hasAppropriateAssertionErrorMessageIfOptionalHasNotValueWithCondition() {
        exception.expect(AssertionError.class);
        exception.expectMessage("greater than <2L>");
        exception.expectMessage("1");

        assertThat(OptionalLong.of(1L), hasValue(greaterThan(2L)));
    }
}