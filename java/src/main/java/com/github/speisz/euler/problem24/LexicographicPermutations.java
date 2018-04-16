package com.github.speisz.euler.problem24;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.difference;
import static com.google.common.collect.Sets.newHashSet;

public class LexicographicPermutations {
    public static Stream<List<String>> stream(Set<String> elements) {
        if (elements.size() == 0) {
            return Stream.of(newArrayList());
        }
        return elements.stream()
                .sorted()
                .flatMap(element -> streamWithElementFirst(elements, element));
    }

    private static Stream<List<String>> streamWithElementFirst(Set<String> elements, String firstElement) {
        return stream(difference(elements, newHashSet(firstElement)))
                .peek(permutation -> permutation.add(0, firstElement));
    }
}
