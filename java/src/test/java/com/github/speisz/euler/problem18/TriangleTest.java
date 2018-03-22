package com.github.speisz.euler.problem18;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class TriangleTest {

    @Test
    public void parsesATriangle() {
        Triangle triangle = new Triangle("" +
                "3\n" +
                "7 4\n" +
                "2 4 6\n" +
                "8 5 9 3");
        assertThat(triangle.getRows(), hasSize(4));
        assertThat(triangle.getRow(0), hasSize(1));
        assertThat(triangle.getRow(0).get(0), is(3));
        assertThat(triangle.getRow(3), hasSize(4));
        assertThat(triangle.getRow(3).get(0), is(8));
        assertThat(triangle.getRow(3).get(3), is(3));
    }

    @Test
    public void calculatesMaximumPathSum() {
        Triangle triangle = new Triangle("" +
                "3\n" +
                "7 4\n" +
                "2 4 6\n" +
                "8 5 9 3");
        assertThat(triangle.calculateMaximumPathSum(), is(3 + 7 + 4 + 9));
    }
}
