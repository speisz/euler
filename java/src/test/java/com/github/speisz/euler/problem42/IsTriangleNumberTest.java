package com.github.speisz.euler.problem42;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class IsTriangleNumberTest {

    private IsTriangleNumber isTriangleNumber = IsTriangleNumber.create();

    @Test
    void testsCorrectlyThatNumberIsTriangleNumber() {
        assertThat(isTriangleNumber.test(1), is(true));
        assertThat(isTriangleNumber.test(1 + 2), is(true));
        assertThat(isTriangleNumber.test(1 + 2 + 3), is(true));
        assertThat(isTriangleNumber.test(1 + 2 + 3 + 4), is(true));
        assertThat(isTriangleNumber.test(5050), is(true));
    }

    @Test
    void testsCorrectlyThatNumberIsNotTriangleNumber() {
        assertThat(isTriangleNumber.test(2), is(false));
        assertThat(isTriangleNumber.test(4), is(false));
        assertThat(isTriangleNumber.test(5051), is(false));
    }
}
