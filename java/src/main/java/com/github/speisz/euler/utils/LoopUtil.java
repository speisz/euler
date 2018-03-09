package com.github.speisz.euler.utils;

import static java.util.stream.LongStream.rangeClosed;

public class LoopUtil {
    public static void repeatNTimes(long n, Runnable action) {
        rangeClosed(1, n).forEach(ignored -> action.run());
    }
}
