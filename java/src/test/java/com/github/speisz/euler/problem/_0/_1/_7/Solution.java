package com.github.speisz.euler.problem._0._1._7;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static com.github.speisz.euler.utils.StringUtil.countChars;
import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    @Test
    void countsCharsOfWordOfNumber() {
        assertThat(countChars(WordOfNumber.get(342)), is(23L));
        assertThat(countChars(WordOfNumber.get(115)), is(20L));
    }

    @Test
    void countsCharsOfAllWordsUpTo5() {
        assertThat(countChars(numberWordsUpTo(5)), is(19L));
    }

    @Test
    void countsCharsOfAllWordsUpTo1000() {
        assertThat(countChars(numberWordsUpTo(1000)), is(21124L));
    }

    private Stream<String> numberWordsUpTo(int upperBound) {
        return rangeClosed(1, upperBound).mapToObj(WordOfNumber::get);
    }
}
