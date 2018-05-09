package com.github.speisz.euler.utils;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public final class IntUtil {

    public static int concat(int... integers) {
        return Integer.parseInt(IntStream.of(integers)
                .boxed()
                .map(String::valueOf)
                .collect(joining()));
    }

    private IntUtil() {
    }
}
