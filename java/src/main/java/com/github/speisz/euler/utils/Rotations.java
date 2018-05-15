package com.github.speisz.euler.utils;

import java.util.stream.Stream;

import static java.util.stream.IntStream.range;

public class Rotations {

    public static Stream<String> stream(String string) {
        return range(0, string.length()).mapToObj(position -> rotatedString(string, position));
    }

    private static String rotatedString(String string, int startPosition) {
        return string.substring(startPosition, string.length()) + string.substring(0, startPosition);
    }

    public static Stream<Integer> stream(int n) {
        return stream(String.valueOf(n)).map(Integer::parseInt);
    }

    private Rotations() {
    }
}
