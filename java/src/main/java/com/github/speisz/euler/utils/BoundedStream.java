package com.github.speisz.euler.utils;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class BoundedStream<T> {

    private Stream<T> stream;
    private Predicate<T> conditionExclusive;
    private Predicate<T> conditionInclusive;

    private BoundedStream(Stream<T> stream) {
        this.stream = stream;
        this.conditionExclusive = t -> true;
        this.conditionInclusive = t -> true;
    }

    public static <T> BoundedStream<T> of(Stream<T> stream) {
        return new BoundedStream<>(stream);
    }

    public BoundedStream<T> withConditionExclusive(Predicate<T> condition) {
        conditionExclusive = condition;
        return this;
    }

    public BoundedStream<T> withConditionInclusive(Predicate<T> condition) {
        conditionInclusive = condition;
        return this;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void doForEach(Consumer<T> consumer) {
        stream
                .peek(element -> Optional.of(element)
                        .filter(conditionExclusive)
                        .ifPresent(consumer))
                .allMatch(allConditions());
    }

    private Predicate<T> allConditions() {
        return conditionExclusive.and(conditionInclusive);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public boolean noneMatch(Predicate<T> predicate) {
        final AtomicBoolean noneMatchPredicate = new AtomicBoolean(true);
        stream
                .peek(element -> Optional.of(element)
                        .filter(conditionExclusive)
                        .ifPresent(t -> {
                            if (predicate.test(t)) {
                                noneMatchPredicate.set(false);
                            }
                        }))
                .allMatch(allConditions().and(predicate.negate()));
        return noneMatchPredicate.get();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public Stream<T> get() {
        Stream.Builder<T> streamBuilder = Stream.builder();
        stream
                .peek(element -> Optional.of(element)
                        .filter(conditionExclusive)
                        .ifPresent(streamBuilder::add))
                .allMatch(allConditions());
        return streamBuilder.build();
    }
}
