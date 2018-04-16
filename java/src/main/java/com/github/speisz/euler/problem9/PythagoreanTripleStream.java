package com.github.speisz.euler.problem9;

import com.github.speisz.euler.utils.MathUtil;
import com.github.speisz.euler.utils.TripleUtil;
import org.apache.commons.lang3.tuple.Pair;
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

    private Stream<Triple<Integer, Integer, Integer>> descendingTripleStream(Stream<Pair<Integer, Integer>> tupleStream) {
        return tupleStream
                .map(this::allDescendingTriples)
                .flatMap(identity());
    }

    private Stream<Pair<Integer, Integer>> descendingTupleStream(IntStream stream) {
        return stream
                .mapToObj(this::allDescendingTuples)
                .flatMap(identity());
    }

    private Stream<Triple<Integer, Integer, Integer>> allDescendingTriples(Pair<Integer, Integer> tuple) {
        return range(1, tuple.getRight()).mapToObj(third -> Triple.of(tuple.getLeft(), tuple.getRight(), third));
    }

    private Stream<Pair<Integer, Integer>> allDescendingTuples(int first) {
        return range(1, first).mapToObj(second -> Pair.of(first, second));
    }
}
