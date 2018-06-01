package com.github.speisz.euler.utils;

import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class BoundedIntStream {

    private IntStream stream;
    private IntPredicate conditionExclusive;
    private IntPredicate conditionInclusive;
    private IntPredicate breakConditionInclusive;

    private BoundedIntStream(IntStream stream) {
        this.stream = stream;
        this.conditionExclusive = t -> true;
        this.conditionInclusive = t -> true;
        this.breakConditionInclusive = t -> false;
    }

    public static BoundedIntStream of(IntStream stream) {
        return new BoundedIntStream(stream);
    }

    public BoundedIntStream withConditionExclusive(IntPredicate condition) {
        conditionExclusive = condition;
        return this;
    }

    public BoundedIntStream withConditionInclusive(IntPredicate condition) {
        conditionInclusive = condition;
        return this;
    }

    public BoundedIntStream withBreakConditionInclusive(IntPredicate condition) {
        breakConditionInclusive = condition;
        return this;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void doForEach(IntConsumer consumer) {
        stream
                .peek(element -> IntStream.of(element)
                        .filter(conditionExclusive)
                        .forEach(consumer))
                .allMatch(allConditions());
    }

    private IntPredicate allConditions() {
        return conditionExclusive.and(conditionInclusive).and(breakConditionInclusive.negate());
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public boolean noneMatch(IntPredicate predicate) {
        final AtomicBoolean noneMatchPredicate = new AtomicBoolean(true);
        stream
                .peek(element -> IntStream.of(element)
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
    public IntStream get() {
        IntStream.Builder streamBuilder = IntStream.builder();
        stream
                .peek(element -> IntStream.of(element)
                        .filter(conditionExclusive)
                        .forEach(streamBuilder::add))
                .allMatch(allConditions());
        return streamBuilder.build();
    }
}
