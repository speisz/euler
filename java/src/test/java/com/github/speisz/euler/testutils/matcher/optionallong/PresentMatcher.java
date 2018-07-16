package com.github.speisz.euler.testutils.matcher.optionallong;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.OptionalLong;

public class PresentMatcher extends TypeSafeMatcher<OptionalLong> {
    public static PresentMatcher present() {
        return new PresentMatcher();
    }

    @Override
    protected boolean matchesSafely(OptionalLong actual) {
        return actual.isPresent();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a non-empty optional");
    }

    @Override
    protected void describeMismatchSafely(OptionalLong actual, Description mismatchDescription) {
        mismatchDescription.appendText("an empty optional");
    }

    private PresentMatcher() {
    }
}
