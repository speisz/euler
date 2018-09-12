package com.github.speisz.euler.problem._0._2._6;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.github.speisz.euler.testutils.matcher.OptionalMatchers.hasValue;
import static java.util.Comparator.comparing;
import static java.util.stream.IntStream.range;
import static org.hamcrest.MatcherAssert.assertThat;

class Solution {
    @Test
    void findsDenominatorWithLongestCycleInUnitFraction() {
        Optional<Integer> denominatorWithMaxCycleLength = range(1, 1000)
                .boxed()
                .map(d -> Pair.of(d, FractionCycleLengthFinder.findFor(d)))
                .max(comparing(Pair::getValue))
                .map(Pair::getKey);

        assertThat(denominatorWithMaxCycleLength, hasValue(983));
    }
}
