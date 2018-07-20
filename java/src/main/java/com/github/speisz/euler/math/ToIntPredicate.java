package com.github.speisz.euler.math;

import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public interface ToIntPredicate extends Predicate<Integer> {
    default IntPredicate toIntPredicate() {
        return this::test;
    }
}
