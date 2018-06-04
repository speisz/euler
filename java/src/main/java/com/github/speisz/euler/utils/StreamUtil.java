package com.github.speisz.euler.utils;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.function.Function.identity;
import static java.util.stream.IntStream.range;

public class StreamUtil {
    public static <T> Optional<T> lastElement(Stream<T> stream) {
        return stream.reduce((first, second) -> second);
    }

    public static OptionalInt lastElement(IntStream stream) {
        return stream.reduce((first, second) -> second);
    }

    public static Stream<Triple<Integer, Integer, Integer>> descendingTripleStream(Stream<Pair<Integer, Integer>> tupleStream) {
        return tupleStream
                .map(StreamUtil::descendingTripleStream)
                .flatMap(identity());
    }

    public static Stream<Pair<Integer, Integer>> descendingPairStream(IntStream stream) {
        return stream
                .mapToObj(first -> range(1, first).mapToObj(second -> Pair.of(first, second)))
                .flatMap(identity());
    }

    public static IntStream.Builder streamBuilderFrom(IntStream stream) {
        return stream.collect(IntStream::builder, IntStream.Builder::accept, (first, second) -> second.build().forEach(first));
    }

    public static <T> Stream.Builder<T> streamBuilderFrom(Stream<T> stream) {
        return stream.collect(Stream::builder, Stream.Builder::accept, (first, second) -> second.build().forEach(first));
    }

    private static Stream<Triple<Integer, Integer, Integer>> descendingTripleStream(Pair<Integer, Integer> tuple) {
        return range(1, tuple.getRight()).mapToObj(third -> Triple.of(tuple.getLeft(), tuple.getRight(), third));
    }

    public static <T> Stream<Pair<T, T>> pairStream(Supplier<Stream<T>> streamSupplier) {
        return pairStream(streamSupplier, streamSupplier);
    }

    public static <T, U> Stream<Pair<T, U>> pairStream(Supplier<Stream<T>> firstStreamSupplier, Supplier<Stream<U>> secondStreamSupplier) {
        return firstStreamSupplier.get()
                .flatMap(first -> secondStreamSupplier.get().map(second -> Pair.of(first, second)));
    }

    /* Optimization for stream.max(comparing(comparingFunction)) to evaluate comparingFunction only once per element. */
    public static <T, U extends Comparable<? super U>> Optional<T> max(Stream<T> stream, Function<T, U> comparingFunction) {
        return stream
                .map(element -> Pair.of(element, comparingFunction.apply(element)))
                .max(comparing(Pair::getValue))
                .map(Pair::getLeft);
    }

    public static <T> Optional<T> nthElement(Stream<T> stream, long number) {
        return lastElement(stream.limit(number));
    }
}
