package com.github.speisz.euler.utils;

import java.util.Collection;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public final class IntUtil {

    public static int concat(Stream<Integer> stream) {
        return Integer.parseInt(stream
                .map(String::valueOf)
                .collect(joining()));
    }

    public static int concat(int... integers) {
        return concat(IntStream.of(integers).boxed());
    }

    public static int concat(Collection<Integer> integers) {
        return concat(integers.stream());
    }

    public static IntPredicate containedIn(int n) {
        return digit -> LongUtil.containedIn((long) n).test(digit);
    }

    private IntUtil() {
    }
}
