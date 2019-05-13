package com.github.speisz.euler.problem._0._6._1;

import com.github.speisz.euler.math.polygonal.Polygonals;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

class Solution {
    @Test
    void ___() {
        List<Long> triangles = LongStream.iterate(1, n -> n + 1)
                .map(Polygonals::triangle)
                .filter(t -> t >= 1_010)
                .filter(t -> t % 100 >= 10)
                .takeWhile(t -> t < 10_000)
                .boxed().collect(toList());
    }
}
