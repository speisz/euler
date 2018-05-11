package com.github.speisz.euler.problem32;

import java.util.function.Predicate;

import static com.github.speisz.euler.utils.LongUtil.containedIn;
import static com.github.speisz.euler.utils.MathUtil.digits;
import static java.util.stream.LongStream.rangeClosed;

public class IsPandigital implements Predicate<Long> {
    static boolean isPandigital(long n) {
        return new IsPandigital().test(n);
    }

    @Override
    public boolean test(Long n) {
        return rangeClosed(1, digits(n).count()).allMatch(containedIn(n));
    }

}
