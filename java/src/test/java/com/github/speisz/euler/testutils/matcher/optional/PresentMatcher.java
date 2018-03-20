package com.github.speisz.euler.testutils.matcher.optional;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.Optional;

public class PresentMatcher<T> extends TypeSafeMatcher<Optional<T>> {
    public static <T> PresentMatcher<T> present() {
        return new PresentMatcher<>();
    }

    @Override
    protected boolean matchesSafely(Optional<T> actual) {
        return actual.isPresent();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a non-empty optional");
    }

    @Override
    protected void describeMismatchSafely(Optional<T> actual, Description mismatchDescription) {
        mismatchDescription.appendText("an empty optional");
    }

    private PresentMatcher() {
    }
}
