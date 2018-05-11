package com.github.speisz.euler.utils;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public final class IntUtil {

    public static int concat(int... integers) {
        return Integer.parseInt(IntStream.of(integers)
                .boxed()
                .map(String::valueOf)
                .collect(joining()));
    }

    public static IntPredicate containedIn(int n) {
        return digit -> LongUtil.containedIn((long) n).test(digit);
    }

    private IntUtil() {
    }
}
