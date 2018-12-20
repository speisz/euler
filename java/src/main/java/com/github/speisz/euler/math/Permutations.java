package com.github.speisz.euler.math;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

public class Permutations {

    private Permutations() {
    }

    private static <T> List<T> permutation(long number, List<T> items) {
        return permutationHelper(number, new LinkedList<>(items), new ArrayList<>());
    }

    private static <T> List<T> permutationHelper(long number, List<T> in, List<T> out) {
        if (in.isEmpty()) {
            return out;
        }
        long subFactorial = Factorial.asIntegerOf(in.size() - 1);
        move((int) (number / subFactorial), in, out);
        return permutationHelper((int) (number % subFactorial), in, out);
    }

    private static <T> void move(int index, List<T> from, List<T> to) {
        to.add(from.get(index));
        from.remove(index);
    }

    @SafeVarargs
    public static <T> Stream<Stream<T>> streamsOf(T... items) {
        return streamsOf(List.of(requireNonNull(items)));
    }

    public static <T> Stream<Stream<T>> streamsOf(List<T> items) {
        return Permutations.of(items).map(Collection::stream);
    }

    @SafeVarargs
    public static <T> Stream<List<T>> of(T... items) {
        return of(List.of(requireNonNull(items)));
    }

    public static <T> Stream<List<T>> of(Collection<T> items) {
        return LongStream.range(0, Factorial.asIntegerOf(items.size()))
                .mapToObj(number -> permutation(number, List.copyOf(items)));
    }

    public static <T> Stream<Stream<T>> streamsOfLengthTwo(Collection<T> items) {
        return items.stream()
                .flatMap(item -> items.stream()
                        .filter(innerItem -> item != innerItem)
                        .map(innerItem -> Stream.of(item, innerItem)))
                .distinct();
    }
}
