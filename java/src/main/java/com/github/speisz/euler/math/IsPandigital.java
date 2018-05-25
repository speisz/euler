package com.github.speisz.euler.math;

import java.util.function.LongPredicate;
import java.util.function.Predicate;

import static com.github.speisz.euler.utils.LongUtil.containedIn;
import static com.github.speisz.euler.utils.MathUtil.digits;
import static java.util.stream.LongStream.rangeClosed;

public class IsPandigital implements Predicate<Long> {

    public static IsPandigital isPandigital() {
        return new IsPandigital();
    }

    public static LongPredicate asLongPredicate() {
        return n -> isPandigital().test(n);
    }

    public static boolean isPandigital(long n) {
        return isPandigital().test(n);
    }

    @Override
    public boolean test(Long n) {
        return rangeClosed(1, digits(n).count()).allMatch(containedIn(n));
    }

    private IsPandigital() {
    }
}
