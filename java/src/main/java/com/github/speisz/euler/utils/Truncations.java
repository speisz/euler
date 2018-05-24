package com.github.speisz.euler.utils;

import java.util.stream.Stream;

import static java.util.stream.IntStream.range;
import static java.util.stream.Stream.concat;

public class Truncations {
    public static Stream<String> stream(String string) {
        return concat(streamLeftTruncated(string), streamRightTruncated(string));
    }

    private static Stream<String> streamRightTruncated(String string) {
        return range(1, string.length())
                .map(index -> string.length() - index)
                .mapToObj(index -> string.substring(0, index));
    }

    private static Stream<String> streamLeftTruncated(String string) {
        return range(1, string.length())
                .mapToObj(string::substring);
    }

    public static Stream<Long> stream(long n) {
        return stream(String.valueOf(n)).map(Long::parseLong);
    }

    public static Stream<Integer> stream(int n) {
        return stream(String.valueOf(n)).map(Integer::parseInt);
    }

    private Truncations() {
    }
}
