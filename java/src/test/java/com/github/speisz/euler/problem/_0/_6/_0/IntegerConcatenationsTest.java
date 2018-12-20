package com.github.speisz.euler.problem._0._6._0;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

class IntegerConcatenationsTest {
    @Test
    void buildsAllConcatenationsOfGivenIntegers() {
        List<Integer> concatenations = IntegerConcatenations.getFor(1, 2, 3).collect(toList());
        assertThat(concatenations, hasItems(12, 21, 23, 32, 13, 31));
    }
}
