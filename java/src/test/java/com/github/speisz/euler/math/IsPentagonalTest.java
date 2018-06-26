package com.github.speisz.euler.math;

import org.junit.Test;

import java.util.function.LongPredicate;
import java.util.stream.LongStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsPentagonalTest {

    private static final IsPentagonal IS_PENTAGONAL = IsPentagonal.create();
    private static final LongPredicate IS_PENTAGONAL_LONG = IS_PENTAGONAL.toLongPredicate();

    @Test
    public void testsThatNumberIsPentagonal() {
        LongStream.of(1L, 5L, 12L, 22L, 35L, 70L, 145L)
                .forEach(pentagonal -> assertTrue(IS_PENTAGONAL.test(pentagonal)));
    }

    @Test
    public void testsThatNumberIsNotPentagonal() {
        LongStream.of(2L, 3L, 4L, 6L, 7L, 146L)
                .forEach(nonPentagonal -> assertFalse(IS_PENTAGONAL.test(nonPentagonal)));
    }

    @Test
    public void check1() {
        long count = LongStream.range(0, Integer.MAX_VALUE)
                .parallel()
                .filter(IS_PENTAGONAL_LONG)
                .count();
        System.out.println(count);
    }

    @Test
    public void check2() {
        long count = LongStream.range(0, Integer.MAX_VALUE)
                .parallel()
                .filter(IS_PENTAGONAL_LONG)
                .count();
        System.out.println(count);
    }
}
