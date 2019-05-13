package com.github.speisz.euler.math.polygonal;

import org.junit.jupiter.api.Test;

import java.util.function.LongPredicate;
import java.util.stream.LongStream;

import static java.util.stream.LongStream.range;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsHexagonalTest {

    private static final IsHexagonal IS_HEXAGONAL = IsHexagonal.create();
    private static final LongPredicate IS_HEXAGONAL_LONG = IS_HEXAGONAL.toLongPredicate();

    @Test
    void testsThatNumberIsHexagonal() {
        LongStream.of(1L, 6L, 15L, 28L, 45L, 40_755L)
                .forEach(pentagonal -> assertTrue(IS_HEXAGONAL.test(pentagonal)));
    }

    @Test
    void testsThatNumberIsNotHexagonal() {
        LongStream.of(0L, 2L, 3L, 4L, 5L, 7L, 40_756L)
                .forEach(nonHexagonal -> assertFalse(IS_HEXAGONAL.test(nonHexagonal)));
    }

    @Test
    void isEfficient() {
        assertThat(range(0, 10_000_000)
                .filter(IS_HEXAGONAL_LONG)
                .count(), is(2236L));
    }
}
