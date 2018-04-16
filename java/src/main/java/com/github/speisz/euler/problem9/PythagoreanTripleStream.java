package com.github.speisz.euler.problem9;

import com.github.speisz.euler.utils.MathUtil;
import com.github.speisz.euler.utils.TripleUtil;
import com.github.speisz.euler.utils.Pair;
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
                .map(TripleUtil::swapLeftAndRight)
                .filter(MathUtil::isPythagorean);
    }

    private Stream<Triple<Integer, Integer, Integer>> descendingTripleStream(Stream<Pair<Integer>> tupleStream) {
        return tupleStream
                .map(this::allDescendingTriples)
                .flatMap(identity());
    }

    private Stream<Pair<Integer>> descendingTupleStream(IntStream stream) {
        return stream
                .mapToObj(this::allDescendingTuples)
                .flatMap(identity());
    }

    private Stream<Triple<Integer, Integer, Integer>> allDescendingTriples(Pair<Integer> tuple) {
        return range(1, tuple.second).mapToObj(third -> Triple.of(tuple.first, tuple.second, third));
    }

    private Stream<Pair<Integer>> allDescendingTuples(int first) {
        return range(1, first).mapToObj(second -> Pair.of(first, second));
    }
}
