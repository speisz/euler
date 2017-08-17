package utils;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Tuple<T> {
    public final T first;
    public final T second;

    private Tuple(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public static <T> Tuple<T> of(T first, T second) {
        return new Tuple<>(first, second);
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

        Tuple<?> tuple = (Tuple<?>) o;

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
