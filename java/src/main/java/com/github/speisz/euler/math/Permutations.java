package com.github.speisz.euler.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

public class Permutations {

    private Permutations() {
    }

    private static <T> List<T> permutation(long number, List<T> items) {
        return permutationHelper(number, new LinkedList<>(items), new ArrayList<>());
    }

    private static <T> List<T> permutationHelper(long number, LinkedList<T> in, List<T> out) {
        if (in.isEmpty()) {
            return out;
        }
        long subFactorial = Factorial.asIntegerOf(in.size() - 1);
        move((int) (number / subFactorial), in, out);
        return permutationHelper((int) (number % subFactorial), in, out);
    }

    private static <T> void move(int index, LinkedList<T> from, List<T> to) {
        to.add(from.get(index));
        from.remove(index);
    }

    @SafeVarargs
    @SuppressWarnings("varargs")
    public static <T> Stream<Stream<T>> of(T... items) {
        return of(Arrays.asList(requireNonNull(items)));
    }

    private static <T> Stream<Stream<T>> of(List<T> items) {
        return LongStream.range(0, Factorial.asIntegerOf(items.size()))
                .mapToObj(number -> permutation(number, items).stream());
    }
}
