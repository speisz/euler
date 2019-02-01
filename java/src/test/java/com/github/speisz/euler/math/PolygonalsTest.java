package com.github.speisz.euler.math;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.LongUnaryOperator;

import static com.github.speisz.euler.stream.LongStreams.sequence;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class PolygonalsTest {

    @Test
    void calculatesTriangles() {
        assertThat(firstFivePolygonals(Polygonals::triangle), contains(1L, 3L, 6L, 10L, 15L));
    }

    @Test
    void calculatesSquares() {
        assertThat(firstFivePolygonals(Polygonals::square), contains(1L, 4L, 9L, 16L, 25L));
    }

    @Test
    void calculatesPentagonals() {
        assertThat(firstFivePolygonals(Polygonals::pentagonal), contains(1L, 5L, 12L, 22L, 35L));
    }

    @Test
    void calculatesHexagonals() {
        assertThat(firstFivePolygonals(Polygonals::hexagonal), contains(1L, 6L, 15L, 28L, 45L));
    }

    @Test
    void calculatesHeptagonals() {
        assertThat(firstFivePolygonals(Polygonals::heptagonal), contains(1L, 7L, 18L, 34L, 55L));
    }

    @Test
    void calculatesOctagonals() {
        assertThat(firstFivePolygonals(Polygonals::octagonal), contains(1L, 8L, 21L, 40L, 65L));
    }
    
    private List<Long> firstFivePolygonals(LongUnaryOperator type) {
        return sequence().map(type).limit(5).boxed().collect(toList());
    }
}
