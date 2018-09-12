package com.github.speisz.euler.problem._0._0._4;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static com.github.speisz.euler.problem._0._0._4.CartesianProduct.computeFor;
import static com.github.speisz.euler.problem._0._0._4.CartesianProduct.computeForStreams;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

class CartesianProductTest {

    @Test
    void buildsCartesianForTwoOneElementCollections() {
        List<Pair<String, String>> product = computeFor(singletonList("a"), singletonList("b"));
        assertThat(product, hasSize(1));
        assertThat(product, hasItem(Pair.of("a", "b")));
    }

    @Test
    void buildsCartesianForTwoArbitraryCollections() {
        List<Pair<String, String>> product = computeFor(asList("a", "b"), asList("a", "d", "e"));
        assertThat(product, hasSize(6));
        assertThat(product, hasItems(
                Pair.of("a", "a"),
                Pair.of("a", "d"),
                Pair.of("a", "e"),
                Pair.of("b", "a"),
                Pair.of("b", "d"),
                Pair.of("b", "e")
        ));
    }

    @Test
    void buildsCartesianStreamForTwoArbitraryStreams() {
        List<Pair<String, String>> product = computeForStreams(() -> Stream.of("a", "b"), () -> Stream.of("a", "d", "e")).collect(toList());
        assertThat(product, hasSize(6));
        assertThat(product, hasItems(
                Pair.of("a", "a"),
                Pair.of("a", "d"),
                Pair.of("a", "e"),
                Pair.of("b", "a"),
                Pair.of("b", "d"),
                Pair.of("b", "e")
        ));
    }
}
