package com.github.speisz.euler.problem4;

import com.github.speisz.euler.utils.Pair;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;

class CartesianProduct {
    static <T> List<Pair<T>> computeFor(List<T> first, List<T> second) {
        return computeForStreams(first::stream, second::stream).collect(toList());
    }

    static <T> Stream<Pair<T>> computeForStreams(Supplier<Stream<T>> first, Supplier<Stream<T>> second) {
        return first.get()
                .map(left -> second.get().map(right -> Pair.of(left, right)))
                .flatMap(identity());
    }

    private CartesianProduct() {
    }
}
