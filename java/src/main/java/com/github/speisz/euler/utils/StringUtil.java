package com.github.speisz.euler.utils;

import java.util.function.Function;
import java.util.function.Supplier;
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

    public static Stream<String> stringCombinations(Supplier<Stream<String>> streamSupplier, int count) {
        return allRepitionsOfStringsHelper(streamSupplier, streamSupplier, count);
    }

    private static Stream<String> allRepitionsOfStringsHelper(Supplier<Stream<String>> currentStream, Supplier<Stream<String>> elementaryStream, int count) {
        if (count == 1) {
            return currentStream.get();
        }
        return allRepitionsOfStringsHelper(() -> currentStream.get().flatMap(append(elementaryStream)), elementaryStream, count - 1);
    }

    private static Function<String, Stream<String>> append(Supplier<Stream<String>> streamSupplier) {
        return existingString -> streamSupplier.get().map(newString -> existingString + newString);
    }

    private StringUtil() {
    }
}
