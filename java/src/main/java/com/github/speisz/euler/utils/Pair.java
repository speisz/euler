package com.github.speisz.euler.utils;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Pair<T> {
    public final T first;
    public final T second;

    private Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public static <T> Pair<T> of(T first, T second) {
        return new Pair<>(first, second);
    }

    public T first() {
        return first;
    }

    public T second() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Pair<?> tuple = (Pair<?>) o;

        return new EqualsBuilder()
                .append(first, tuple.first)
                .append(second, tuple.second)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(first)
                .append(second)
                .toHashCode();
    }
}
