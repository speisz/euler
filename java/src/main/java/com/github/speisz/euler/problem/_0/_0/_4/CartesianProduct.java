package com.github.speisz.euler.problem._0._0._4;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;

class CartesianProduct {
    static <T> List<Pair<T, T>> computeFor(List<T> first, List<T> second) {
        return computeForStreams(first::stream, second::stream).collect(toList());
    }

    static <T> Stream<Pair<T, T>> computeForStreams(Supplier<Stream<T>> first, Supplier<Stream<T>> second) {
        return first.get()
                .map(left -> second.get().map(right -> Pair.of(left, right)))
                .flatMap(identity());
    }

    private CartesianProduct() {
    }
}
