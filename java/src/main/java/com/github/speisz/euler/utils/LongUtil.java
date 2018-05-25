package com.github.speisz.euler.utils;

import java.util.function.LongPredicate;
import java.util.function.ToLongFunction;
import java.util.stream.LongStream;

import static com.github.speisz.euler.utils.MathUtil.digits;
import static java.util.stream.Collectors.joining;

public final class LongUtil {

    public static ToLongFunction<Integer> identity() {
        return n -> n;
    }
    
    public static LongPredicate containedIn(Long n) {
        return digit -> digits(n).anyMatch(digitOfN -> digitOfN == digit);
    }

    public static long concat(long... longs) {
        return concat(LongStream.of(longs));
    }

    public static long concat(LongStream longStream) {
        return Long.parseLong(longStream
                .boxed()
                .map(String::valueOf)
                .collect(joining()));
    }

    private LongUtil() {
    }
}
