package utils;

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
}
