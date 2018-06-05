package com.github.speisz.euler.utils;

import java.util.function.Function;

public interface WordValueCalculator extends Function<String, Integer> {
    int calculateFor(String word);

    @Override
    default Integer apply(String word) {
        return calculateFor(word);
    }
}
