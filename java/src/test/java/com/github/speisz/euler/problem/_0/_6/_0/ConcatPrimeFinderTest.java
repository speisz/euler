package com.github.speisz.euler.problem._0._6._0;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

class ConcatPrimeFinderTest {

    @Test
    void findsPrimesSoThatEachConcatenationWithGivenNumberIsPrime() {
        assertThat(ConcatPrimeFinder.forUpperBound(20)
                .findFor(3)
                .collect(toList()), containsInAnyOrder(Set.of(3, 7), Set.of(3, 11), Set.of(3, 17)));
    }

    @Test
    void findsPrimesSoThatEachConcatenationWithGivenNumbersIsPrime() {
        assertThat(ConcatPrimeFinder.forUpperBound(1000)
                .findFor(Set.of(3, 7, 109))
                .collect(toList()), containsInAnyOrder(Set.of(3, 7, 109, 673)));
    }

    @Test
    void returnsEmptyIfNoConcatenationIsPrime() {
        assertThat(ConcatPrimeFinder.forUpperBound(10)
                .findFor(Set.of(3, 7))
                .collect(toList()), is(empty()));
    }
}