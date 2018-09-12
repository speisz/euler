package com.github.speisz.euler.problem24;

import com.github.speisz.euler.utils.LexicographicPermutations;
import com.github.speisz.euler.utils.StreamUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {
    @Test
    void findsMillionthPermutationOfDigits() {
        String millionthPermutation = StreamUtil.lastElement(LexicographicPermutations.stream(rangeAsList(0, 9)).limit(1_000_000))
                .map(permutation -> permutation.stream().collect(joining()))
                .orElseThrow(() -> new RuntimeException("No permutations were generated."));

        assertThat(millionthPermutation, is("2783915460"));
    }

    @SuppressWarnings("SameParameterValue")
    private List<String> rangeAsList(int startInclusive, int endInclusive) {
        return rangeClosed(startInclusive, endInclusive).boxed().map(String::valueOf).collect(toList());
    }
}
