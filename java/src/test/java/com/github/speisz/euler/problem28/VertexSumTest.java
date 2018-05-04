package com.github.speisz.euler.problem28;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class VertexSumTest {

    @Test
    public void sumsValuesOfVertexes() {
        assertThat(VertexSum.computeForIndex(0), is(4));
        assertThat(VertexSum.computeForIndex(1), is(3 + 5 + 7 + 9));
        assertThat(VertexSum.computeForIndex(2), is(13 + 17 + 21 + 25));
    }
}
