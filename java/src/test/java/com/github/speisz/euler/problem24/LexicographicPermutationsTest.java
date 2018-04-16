package com.github.speisz.euler.problem24;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class LexicographicPermutationsTest {
    @Test
    public void streamsPermutations() {
        Stream<List<String>> permutationsStream = LexicographicPermutations.stream(Stream.of("a", "b", "c").collect(toSet()));
        assertThat(permutationsStream.collect(toList()), contains(
                asList("a", "b", "c"),
                asList("a", "c", "b"),
                asList("b", "a", "c"),
                asList("b", "c", "a"),
                asList("c", "a", "b"),
                asList("c", "b", "a")
        ));
    }
}
