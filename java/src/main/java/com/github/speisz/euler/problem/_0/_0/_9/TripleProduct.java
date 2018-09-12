package com.github.speisz.euler.problem._0._0._9;

import org.apache.commons.lang3.tuple.Triple;

import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class TripleProduct {
    private Supplier<Stream<Triple<Integer, Integer, Integer>>> tripleSupplier;

    TripleProduct(Supplier<Stream<Triple<Integer, Integer, Integer>>> tripleSupplier) {
        this.tripleSupplier = tripleSupplier;
    }

    public int computeFirst() {
        return computeFirst(t -> true);
    }

    public int computeFirst(Predicate<Triple<Integer, Integer, Integer>> condition) {
        return tripleSupplier.get()
                .filter(condition)
                .findFirst()
                .map(triple -> triple.getLeft() * triple.getMiddle() * triple.getRight())
                .orElseThrow(() -> new IllegalArgumentException("Did not find any triple product"));
    }
}
