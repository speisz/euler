package com.github.speisz.euler.problem14;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Stream.iterate;

public class Sequence<T> {
    private T seed;
    private final UnaryOperator<T> rule;
    private final Predicate<T> condition;

    Sequence(T seed, UnaryOperator<T> rule, Predicate<T> condition) {
        this.seed = seed;
        this.rule = rule;
        this.condition = condition;
    }

    public Stream<T> compute() {
        return iterate(seed, rule).takeWhile(condition);
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    static class Builder<T> {
        private T seed;
        private UnaryOperator<T> rule;
        private Predicate<T> condition;

        private Builder() {
        }

        public Builder<T> withSeed(T seed) {
            this.seed = seed;
            return this;
        }

        public Builder<T> withRule(UnaryOperator<T> rule) {
            this.rule = rule;
            return this;
        }

        public Builder<T> withCondition(Predicate<T> condition) {
            this.condition = condition;
            return this;
        }

        public Sequence<T> build() {
            return new Sequence<>(requireNonNull(seed), requireNonNull(rule), requireNonNull(condition));
        }
    }
}
