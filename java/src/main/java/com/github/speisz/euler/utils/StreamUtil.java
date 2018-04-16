package com.github.speisz.euler.utils;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamUtil {
    public static <T> Optional<T> lastElement(Stream<T> stream) {
        return stream.reduce((first, second) -> second);
    }
}
