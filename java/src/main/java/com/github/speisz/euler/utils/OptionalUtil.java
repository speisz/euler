package com.github.speisz.euler.utils;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalUtil {
    @SafeVarargs
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public static <T> Optional<T> firstNonEmpty(Optional<T> firstChoice, Optional<T>... additionalChoices) {
        return Stream.of(additionalChoices).reduce(firstChoice, OptionalUtil::firstNonEmpty);
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public static <T> Optional<T> firstNonEmpty(Optional<T> firstChoice, Optional<T> secondChoice) {
        return firstChoice
                .map(Optional::of)
                .orElse(secondChoice);
    }
}
