package com.github.speisz.euler.math;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

class PermutationsTest {

    @Test
    void calculatesPermutations() {
        List<List<Integer>> permutations = Permutations.of(1, 2, 3)
                .collect(toList());
        assertThat(permutations, hasItems(asList(1, 2, 3), asList(1, 3, 2), asList(2, 1, 3), asList(2, 3, 1), asList(3, 2, 1), asList(3, 1, 2)));
    }

    @Test
    void calculatesPermutationsOfLengthTwoEfficientlyForManyNumbers() {
        int count = 100;

        List<List<Integer>> permutations = Permutations.streamsOfLengthTwo(range(0, count).boxed().collect(toList()))
                .map(stream -> stream.collect(toList()))
                .collect(toList());

        assertThat(permutations, hasSize(Factorial.of(count).divide(Factorial.of(count - 2)).intValue()));
        assertThat(permutations, hasItems(
                List.of(1, count - 1),
                List.of(2, count - 1),
                List.of(1, count - 2)));
    }
}
