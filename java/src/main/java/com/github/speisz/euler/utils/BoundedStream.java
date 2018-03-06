package com.github.speisz.euler.utils;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class BoundedStream<T> {

    private Stream<T> stream;
    private Predicate<T> condition;

    private BoundedStream(Stream<T> stream) {
        this.stream = stream;
    }

    public static <T> BoundedStream<T> of(Stream<T> stream) {
        return new BoundedStream<>(stream);
    }

    public BoundedStream<T> withBreakCondition(Predicate<T> condition) {
        this.condition = condition;
        return this;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void doForEach(Consumer<T> consumer) {
        stream
                .peek(element -> Optional.of(element)
                        .filter(condition)
                        .ifPresent(consumer))
                .allMatch(condition);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public boolean noneMatch(Predicate<T> predicate) {
        final AtomicBoolean noneMatchPredicate = new AtomicBoolean(true);
        stream
                .peek(element -> Optional.of(element)
                        .filter(condition)
                        .ifPresent(t -> {
                            if (predicate.test(t)) {
                                noneMatchPredicate.set(false);
                            }
                        }))
                .allMatch(condition.and(predicate.negate()));
        return noneMatchPredicate.get();
    }
}
