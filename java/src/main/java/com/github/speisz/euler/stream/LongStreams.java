package com.github.speisz.euler.stream;

import java.util.stream.LongStream;

public class LongStreams {

    public static LongStream sequence() {
        return LongStream.iterate(1, n -> n + 1);
    }
}
