package com.github.speisz.euler.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class StringStream {
    private static final int LOWER_A_ASCII = 97;
    private static final int LOWER_Z_ASCII = 122;

    public static Stream<String> lowerCaseAlphabet() {
        return IntStream.rangeClosed(LOWER_A_ASCII, LOWER_Z_ASCII)
                .mapToObj(bite -> new String(new byte[]{(byte) bite}));
    }

    private StringStream() {
        // hide constructor
    }
}
