package utils;

import java.util.Optional;
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
}
