package com.github.speisz.euler.testutils.matcher.optionalint;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.OptionalInt;

public class PresentMatcher extends TypeSafeMatcher<OptionalInt> {
    public static PresentMatcher present() {
        return new PresentMatcher();
    }

    @Override
    protected boolean matchesSafely(OptionalInt actual) {
        return actual.isPresent();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a non-empty optional");
    }

    @Override
    protected void describeMismatchSafely(OptionalInt actual, Description mismatchDescription) {
        mismatchDescription.appendText("an empty optional");
    }

    private PresentMatcher() {
    }
}
