package com.github.speisz.euler.testutils.matcher.optional;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;

import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class HasValueMatcher<T> extends TypeSafeMatcher<Optional<T>> {

    private Matcher<T> valueMatcher;

    public static <T> HasValueMatcher<T> hasValue(T expectedValue) {
        return new HasValueMatcher<>(is(expectedValue));
    }
    public static <T> HasValueMatcher<T> hasValue(Matcher<T> valueMatcher) {
        return new HasValueMatcher<>(valueMatcher);
    }

    @Override
    protected boolean matchesSafely(Optional<T> actual) {
        return actual.filter(value -> valueMatcher.matches(value)).isPresent();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("an Optional with value that ");
        valueMatcher.describeTo(description);
    }

    private HasValueMatcher(Matcher<T> valueMatcher) {
        this.valueMatcher = valueMatcher;
    }
}
