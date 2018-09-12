package com.github.speisz.euler.problem._0._3._9;

import org.junit.jupiter.api.Test;

import static com.github.speisz.euler.utils.MathUtil.isPythagorean;
import static java.util.Comparator.comparing;
import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    @Test
    void findsPerimeterWithMostIntegralLengthRightAngleTriangles() {
        assertThat(rangeClosed(3, 1000).boxed()
                .max(comparing(this::numberOfIntegralLengthRightAngleTriangles))
                .orElse(3), is(840));
    }

    private int numberOfIntegralLengthRightAngleTriangles(int perimeter) {
        int halfPerimeter = perimeter / 2;
        return (int) range(1, halfPerimeter)
                .mapToLong(a -> range(halfPerimeter - a, halfPerimeter)
                        .filter(b -> isPythagorean(a, b, perimeter - a - b))
//                        .peek(b-> System.out.println(String.format("p=%s: (%s,%s,%s)",perimeter,a,b,perimeter - a - b)))
                        .count())
                .sum();
    }
}
