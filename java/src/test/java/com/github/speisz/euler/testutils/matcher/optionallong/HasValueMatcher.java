package com.github.speisz.euler.testutils.matcher.optionallong;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.OptionalLong;

import static org.hamcrest.Matchers.is;

public class HasValueMatcher extends TypeSafeMatcher<OptionalLong> {

    private Matcher<Long> valueMatcher;

    public static HasValueMatcher hasValue(Long expectedValue) {
        return new HasValueMatcher(is(expectedValue));
    }

    public static HasValueMatcher hasValue(Matcher<Long> valueMatcher) {
        return new HasValueMatcher(valueMatcher);
    }

    @Override
    protected boolean matchesSafely(OptionalLong actual) {
        if (!actual.isPresent()) {
            return false;
        }
        return valueMatcher.matches(actual.getAsLong());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("an Optional with value that ");
        valueMatcher.describeTo(description);
    }

    private HasValueMatcher(Matcher<Long> valueMatcher) {
        this.valueMatcher = valueMatcher;
    }
}
