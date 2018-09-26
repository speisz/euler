package com.github.speisz.euler.problem._0._5._5;

import com.github.speisz.euler.utils.LongPalindromeCheck;
import org.junit.jupiter.api.Test;

import java.util.function.LongPredicate;

import static com.github.speisz.euler.utils.MathUtil.reverse;
import static java.util.stream.LongStream.iterate;
import static java.util.stream.LongStream.range;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    static final LongPredicate IS_PALINDROME = LongPalindromeCheck.create().toLongPredicate();

    @Test
    void findsLychrelNumbers() {
        assertThat(range(0, 10_000)
                .filter(this::isLychrel)
                .count(), is(249L));
    }

    boolean isLychrel(long number) {
        return iterate(number, previous -> previous + reverse(previous))
                .skip(1)
                .limit(50)
                .noneMatch(IS_PALINDROME);
    }
}
