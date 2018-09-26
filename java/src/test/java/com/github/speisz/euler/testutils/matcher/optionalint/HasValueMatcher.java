package com.github.speisz.euler.testutils.matcher.optionalint;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.OptionalInt;

import static org.hamcrest.Matchers.is;

public class HasValueMatcher extends TypeSafeMatcher<OptionalInt> {

    private Matcher<Integer> valueMatcher;

    public static HasValueMatcher hasValue(Integer expectedValue) {
        return new HasValueMatcher(is(expectedValue));
    }

    public static HasValueMatcher hasValue(Matcher<Integer> valueMatcher) {
        return new HasValueMatcher(valueMatcher);
    }

    @Override
    protected boolean matchesSafely(OptionalInt actual) {
        if (!actual.isPresent()) {
            return false;
        }
        return valueMatcher.matches(actual.getAsInt());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("an Optional with value that ");
        valueMatcher.describeTo(description);
    }

    private HasValueMatcher(Matcher<Integer> valueMatcher) {
        this.valueMatcher = valueMatcher;
    }
}
