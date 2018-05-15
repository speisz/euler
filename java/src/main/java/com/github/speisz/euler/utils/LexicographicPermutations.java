package com.github.speisz.euler.utils;

import java.util.List;
import java.util.stream.Stream;

import static com.github.speisz.euler.utils.MathUtil.digits;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LexicographicPermutations {

    public static Stream<Integer> stream(Integer n) {
        return stream(digits(n).boxed().map(String::valueOf).collect(toList()))
                .map(digits -> digits.stream().collect(joining()))
                .map(Integer::parseInt);
    }

    public static Stream<List<String>> stream(List<String> elements) {
        if (elements.size() == 0) {
            return Stream.of(newArrayList());
        }
        return elements.stream()
                .sorted()
                .flatMap(element -> streamWithElementFirst(elements, element))
                .distinct();
    }

    private static Stream<List<String>> streamWithElementFirst(List<String> elements, String firstElement) {
        List<String> elementsWithoutFirst = newArrayList(elements);
        elementsWithoutFirst.remove(firstElement);
        return stream(elementsWithoutFirst).peek(permutation -> permutation.add(0, firstElement));
    }
}
