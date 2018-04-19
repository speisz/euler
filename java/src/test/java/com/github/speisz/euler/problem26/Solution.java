package com.github.speisz.euler.problem26;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.Optional;

import static com.github.speisz.euler.testutils.matcher.OptionalMatchers.hasValue;
import static java.util.Comparator.comparing;
import static java.util.stream.IntStream.range;
import static org.hamcrest.MatcherAssert.assertThat;

public class Solution {
    @Test
    public void findsDenominatorWithLongestCycleInUnitFraction() {
        Optional<Integer> denominatorWithMaxCycleLength = range(1, 1000)
                .boxed()
                .map(d -> Pair.of(d, FractionCycleLengthFinder.findFor(d)))
                .max(comparing(Pair::getValue))
                .map(Pair::getKey);

        assertThat(denominatorWithMaxCycleLength, hasValue(983));
    }
}
