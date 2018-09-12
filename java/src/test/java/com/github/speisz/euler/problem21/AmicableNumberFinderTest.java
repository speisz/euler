package com.github.speisz.euler.problem21;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class AmicableNumberFinderTest {

    @Test
    void findsAmicableNumbers() {
        assertThat(AmicableNumberFinder.create().streamUpTo(1000)
                .boxed()
                .collect(toList()), is(asList(220, 284)));
    }
}
