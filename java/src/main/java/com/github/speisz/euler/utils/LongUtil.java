package com.github.speisz.euler.utils;

import java.util.function.LongPredicate;

import static com.github.speisz.euler.utils.MathUtil.digits;

public final class LongUtil {
    public static LongPredicate containedIn(Long n) {
        return digit -> digits(n).anyMatch(digitOfN -> digitOfN == digit);
    }

    private LongUtil() {
    }
}
