package com.github.speisz.euler.problem9;

import com.github.speisz.euler.utils.MathUtils;
import com.github.speisz.euler.utils.TripleUtils;
import com.github.speisz.euler.utils.Tuple;
import org.apache.commons.lang3.tuple.Triple;

import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.IntStream.iterate;
import static java.util.stream.IntStream.range;

public class PythagoreanTripleStream implements Supplier<Stream<Triple<Integer, Integer, Integer>>> {
    @Override
    public Stream<Triple<Integer, Integer, Integer>> get() {
        return descendingTripleStream(descendingTupleStream(iterate(5, operand -> operand + 1)))
                .map(TripleUtils::swapLeftAndRight)
                .filter(MathUtils::isPythagorean);
    }

    private Stream<Triple<Integer, Integer, Integer>> descendingTripleStream(Stream<Tuple<Integer>> tupleStream) {
        return tupleStream
                .map(this::allDescendingTriples)
                .flatMap(identity());
    }

    private Stream<Tuple<Integer>> descendingTupleStream(IntStream stream) {
        return stream
                .mapToObj(this::allDescendingTuples)
                .flatMap(identity());
    }

    private Stream<Triple<Integer, Integer, Integer>> allDescendingTriples(Tuple<Integer> tuple) {
        return range(1, tuple.second).mapToObj(third -> Triple.of(tuple.first, tuple.second, third));
    }

    private Stream<Tuple<Integer>> allDescendingTuples(int first) {
        return range(1, first).mapToObj(second -> Tuple.of(first, second));
    }
}
