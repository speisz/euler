package com.github.speisz.euler.problem._0._2._8;

import org.junit.jupiter.api.Test;

import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {
    @Test
    void findsDiagonalSum() {
        assertThat(diagonalSum(2), is(101));
        assertThat(diagonalSum(500), is(669171001));
    }

    private int diagonalSum(int index) {
        return rangeClosed(0, index).map(VertexSum::computeForIndex).sum() - 3;
    }
}
