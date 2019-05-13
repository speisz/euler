package com.github.speisz.euler.math.polygonal;

import com.google.common.collect.ImmutableSet;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.LongUnaryOperator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static java.util.stream.LongStream.iterate;

public class PolygonalsComputation {
    private long lastComputedPolygonal;
    private long indexOfLastComputedPolygonal;
    private final Set<Long> computedPolygonals;
    private final LongUnaryOperator nThPolygonal;

    public PolygonalsComputation(LongUnaryOperator nThPolygonal) {
        this.nThPolygonal = nThPolygonal;
        computedPolygonals = new HashSet<>();
        lastComputedPolygonal = 0;
        indexOfLastComputedPolygonal = 0;
    }

    Set<Long> getUpTo(Long lowerBound) {
        if (lowerBound > lastComputedPolygonal) {
            computedPolygonals.addAll(polygonals(indexOfLastComputedPolygonal, lowerBound).collect(toSet()));
        }
        return ImmutableSet.copyOf(computedPolygonals);
    }

    private Stream<Long> polygonals(long startingIndex, Long lowerBound) {
        AtomicBoolean isLowerThanLowerBound = new AtomicBoolean(true);
        return iterate(startingIndex + 1, n -> n + 1)
                .mapToObj(n -> Pair.of(n, nThPolygonal.applyAsLong(n)))
                .takeWhile(p -> isLowerThanLowerBound.get())
                .peek(p -> isLowerThanLowerBound.set(p.getValue() < lowerBound))
                .peek(this::updateComputedState)
                .map(Pair::getValue);
    }

    private void updateComputedState(Pair<Long, Long> indexAndPolygonal) {
        indexOfLastComputedPolygonal = indexAndPolygonal.getKey();
        lastComputedPolygonal = indexAndPolygonal.getValue();
    }
}
