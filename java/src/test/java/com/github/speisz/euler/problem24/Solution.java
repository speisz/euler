package com.github.speisz.euler.problem24;

import com.github.speisz.euler.utils.StreamUtil;
import org.junit.Test;

import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {
    @Test
    public void findsMillionthPermutationOfDigits() {
        String millionthPermutation = StreamUtil.lastElement(LexicographicPermutations.stream(rangeAsSet(0, 9)).limit(1_000_000))
                .map(permutation -> permutation.stream().collect(joining()))
                .orElseThrow(() -> new RuntimeException("No permutations were generated."));

        assertThat(millionthPermutation, is("2783915460"));
    }

    @SuppressWarnings("SameParameterValue")
    private Set<String> rangeAsSet(int startInclusive, int endInclusive) {
        return IntStream.rangeClosed(startInclusive, endInclusive).boxed().map(String::valueOf).collect(toSet());
    }
}
