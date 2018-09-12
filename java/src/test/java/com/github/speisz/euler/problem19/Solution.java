package com.github.speisz.euler.problem19;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static java.util.stream.Stream.iterate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    private static final LocalDateTime FIRST_OF_1901 = LocalDateTime.of(1901, 1, 1, 0, 0);
    private static final LocalDateTime FIRST_OF_2001 = LocalDateTime.of(2001, 1, 1, 0, 0);

    @Test
    void countSundaysOnFirstOfMonthCount() {
        long sundaysOnFirstOfMonthCount = iterate(FIRST_OF_1901, time -> time.plusDays(1))
                .filter(this::isFirstOfMonth)
                .filter(this::isSunday)
                .takeWhile(FIRST_OF_2001::isAfter)
                .count();

        assertThat(sundaysOnFirstOfMonthCount, is(171L));
    }

    private boolean isSunday(LocalDateTime date) {
        return DayOfWeek.SUNDAY.equals(date.getDayOfWeek());
    }

    private boolean isFirstOfMonth(LocalDateTime date) {
        return date.getDayOfMonth() == 1;
    }
}
