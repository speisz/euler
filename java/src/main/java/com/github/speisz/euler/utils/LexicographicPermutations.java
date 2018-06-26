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

    public static Stream<String> stream(String string) {
        return stream(
                string.chars()
                        .mapToObj(item -> (char) item)
                        .collect(toList()))
                .map(chars -> chars.stream().map(String::valueOf).collect(joining()));
    }

    public static <T> Stream<List<T>> stream(List<T> elements) {
        if (elements.size() == 0) {
            return Stream.of(newArrayList());
        }
        return elements.stream()
                .sorted()
                .flatMap(element -> streamWithElementFirst(elements, element));
    }

    private static <T> Stream<List<T>> streamWithElementFirst(List<T> elements, T firstElement) {
        List<T> elementsWithoutFirst = newArrayList(elements);
        elementsWithoutFirst.remove(firstElement);
        return stream(elementsWithoutFirst).peek(permutation -> permutation.add(0, firstElement));
    }
}
