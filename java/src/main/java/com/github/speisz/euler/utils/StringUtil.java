package com.github.speisz.euler.utils;

import java.util.stream.Stream;

public abstract class StringUtil {
    public static long countChars(Stream<String> strings) {
        return strings
                .flatMapToInt(String::chars)
                .count();
    }

    public static long countChars(String string) {
        return string
                .chars()
                .count();
    }

    private StringUtil() {
    }
}
