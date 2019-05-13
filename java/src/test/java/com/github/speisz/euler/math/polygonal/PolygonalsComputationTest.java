package com.github.speisz.euler.math.polygonal;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.function.Supplier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;

class PolygonalsComputationTest {

    private Supplier<PolygonalsComputation> computationSupplier = () -> new PolygonalsComputation(Polygonals::triangle);

    @Test
    void statefullyComputesPolygonals() {
        PolygonalsComputation computation = computationSupplier.get();

        assertThat(computation.getUpTo(15L), contains(1L, 3L, 6L, 10L, 15L));
        assertThat(computation.getUpTo(10L), contains(1L, 3L, 6L, 10L, 15L));
    }

    @Test
    void computesUpToFirstPolygonalEqualToOrGreaterThanGivenLowerBound() {
        assertThat(computationSupplier.get().getUpTo(20L), containsInAnyOrder(1L, 3L, 6L, 10L, 15L, 21L));
        assertThat(computationSupplier.get().getUpTo(21L), containsInAnyOrder(1L, 3L, 6L, 10L, 15L, 21L));
    }

    @Test
    void returnsNewObjectsForEachQuery() {
        PolygonalsComputation computation = computationSupplier.get();

        Set<Long> firstResult = computation.getUpTo(1L);
        Set<Long> secondResult = computation.getUpTo(3L);

        assertThat(firstResult, containsInAnyOrder(1L));
        assertThat(secondResult, containsInAnyOrder(1L, 3L));
    }
}
