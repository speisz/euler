package com.github.speisz.euler.utils;

import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

public class MultiComparator<T> implements Comparator<T> {
    private List<Comparator<T>> comparators;

    @SafeVarargs
    public MultiComparator(Comparator<T>... comparators) {
        this.comparators = asList(comparators);
    }

    public int compare(T first, T second) {
        for (Comparator<T> comparator : comparators) {
            int comparison = comparator.compare(first, second);
            if (comparison != 0) {
                return comparison;
            }
        }
        return 0;
    }
}