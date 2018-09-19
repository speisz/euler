package com.github.speisz.euler.utils;

import java.util.Optional;
import java.util.function.Predicate;

import static java.util.Optional.empty;

public class BinaryMinSearch {
    public static Optional<Integer> binarySearchForMin(Predicate<Integer> condition, int left, int right) {
        return new BinaryMinSearch(condition).search(left, right);
    }

    private Predicate<Integer> condition;

    private BinaryMinSearch(Predicate<Integer> condition) {
        this.condition = condition;
    }

    private Optional<Integer> search(int left, int right) {
        int middle = determineMiddle(left, right);
        boolean conditionFullfilled = condition.test(middle);
        if (middle == right) {
            return conditionFullfilled ? Optional.of(middle) : empty();
        }
        if (conditionFullfilled) {
            return search(left, middle);
        }
        return search(middle + 1, right);
    }

    private static int determineMiddle(int left, int right) {
        return (right + left) / 2;
    }
}
