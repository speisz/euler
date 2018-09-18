package com.github.speisz.euler.math;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

class PermutationsTest {

    @Test
    void calculatesPermutations() {
        List<List<Integer>> permutations = Permutations.of(1, 2, 3)
                .map(permutation -> permutation.collect(toList()))
                .collect(toList());
        assertThat(permutations, hasItems(asList(1, 2, 3), asList(1, 3, 2), asList(2, 1, 3), asList(2, 3, 1), asList(3, 2, 1), asList(3, 1, 2)));
    }
}
