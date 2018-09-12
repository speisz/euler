package com.github.speisz.euler.utils;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.stream.LongStream;

public class BoundedLongStream {

    private LongStream stream;
    private LongPredicate conditionExclusive;
    private LongPredicate conditionInclusive;
    private LongPredicate breakConditionInclusive;

    private BoundedLongStream(LongStream stream) {
        this.stream = stream;
        this.conditionExclusive = t -> true;
        this.conditionInclusive = t -> true;
        this.breakConditionInclusive = t -> false;
    }

    public static BoundedLongStream of(LongStream stream) {
        return new BoundedLongStream(stream);
    }

    public BoundedLongStream withConditionExclusive(LongPredicate condition) {
        conditionExclusive = condition;
        return this;
    }

    public BoundedLongStream withConditionInclusive(LongPredicate condition) {
        conditionInclusive = condition;
        return this;
    }

    public BoundedLongStream withBreakConditionInclusive(LongPredicate condition) {
        breakConditionInclusive = condition;
        return this;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void doForEach(LongConsumer consumer) {
        stream
                .peek(element -> LongStream.of(element)
                        .filter(conditionExclusive)
                        .forEach(consumer))
                .allMatch(allConditions());
    }

    private LongPredicate allConditions() {
        return conditionExclusive.and(conditionInclusive).and(breakConditionInclusive.negate());
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public boolean noneMatch(LongPredicate predicate) {
        final AtomicBoolean noneMatchPredicate = new AtomicBoolean(true);
        stream
                .peek(element -> LongStream.of(element)
                        .filter(conditionExclusive)
                        .forEach(t -> {
                            if (predicate.test(t)) {
                                noneMatchPredicate.set(false);
                            }
                        }))
                .allMatch(allConditions().and(predicate.negate()));
        return noneMatchPredicate.get();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public LongStream get() {
        LongStream.Builder streamBuilder = LongStream.builder();
        stream
                .peek(element -> LongStream.of(element)
                        .filter(conditionExclusive)
                        .forEach(streamBuilder::add))
                .allMatch(allConditions());
        return streamBuilder.build();
    }
}
