package com.github.speisz.euler.problem._0._6._0;

import com.github.speisz.euler.math.Permutations;
import com.github.speisz.euler.utils.IntUtil;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class IntegerConcatenations {
    public static Stream<Integer> getFor(Integer... integers) {
        return getFor(List.of(integers));
    }

    public static Stream<Integer> getFor(Collection<Integer> items) {
        return Permutations.streamsOfLengthTwo(items).map(IntUtil::concat);
    }
}
