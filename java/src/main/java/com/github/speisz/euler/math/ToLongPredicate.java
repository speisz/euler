package com.github.speisz.euler.math;

import java.util.function.LongPredicate;
import java.util.function.Predicate;

public interface ToLongPredicate extends Predicate<Long> {
    default LongPredicate toLongPredicate() {
        return this::test;
    }
}
