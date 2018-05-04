package com.github.speisz.euler.problem28;

import org.junit.Test;

import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {
    @Test
    public void findsDiagonalSum() {
        assertThat(diagonalSum(2), is(101));
        assertThat(diagonalSum(500), is(669171001));
    }

    private int diagonalSum(int index) {
        return rangeClosed(0, index).map(VertexSum::computeForIndex).sum() - 3;
    }
}
