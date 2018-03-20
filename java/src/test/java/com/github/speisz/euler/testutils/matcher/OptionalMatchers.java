package com.github.speisz.euler.testutils.matcher;

import com.github.speisz.euler.testutils.matcher.optional.HasValueMatcher;
import com.github.speisz.euler.testutils.matcher.optional.PresentMatcher;
import org.hamcrest.Matcher;

import java.util.Optional;

public class OptionalMatchers {
    public static <T> Matcher<Optional<T>> present() {
        return PresentMatcher.present();
    }

    public static <T> Matcher<Optional<T>> hasValue(T value) {
        return HasValueMatcher.hasValue(value);
    }

    public static <T> Matcher<Optional<T>> hasValue(Matcher<T> valueCondition) {
        return HasValueMatcher.hasValue(valueCondition);
    }
}
