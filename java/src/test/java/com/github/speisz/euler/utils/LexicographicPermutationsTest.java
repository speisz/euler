package com.github.speisz.euler.utils;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class LexicographicPermutationsTest {

    @Test
    public void streamsPermutations() {
        Stream<List<String>> permutationsStream = LexicographicPermutations.stream(Stream.of("a", "b", "c").collect(toList()));
        assertThat(permutationsStream.collect(toList()), contains(
                asList("a", "b", "c"),
                asList("a", "c", "b"),
                asList("b", "a", "c"),
                asList("b", "c", "a"),
                asList("c", "a", "b"),
                asList("c", "b", "a")
        ));
    }

    @Test
    public void streamsPermutationsOfStrings() {
        Stream<String> permutationsStream = LexicographicPermutations.stream("123");
        assertThat(permutationsStream.collect(toList()), contains("123", "132", "213", "231", "312", "321"));
    }
    
    @Test
    public void streamsPermutationsOfIntegers() {
        Stream<Integer> permutationsStream = LexicographicPermutations.stream(123);
        assertThat(permutationsStream.collect(toList()), contains(123, 132, 213, 231, 312, 321));
    }
}
