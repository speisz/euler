package com.github.speisz.euler.problem4;

import org.junit.Test;
import com.github.speisz.euler.utils.Pair;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static com.github.speisz.euler.problem4.CartesianProduct.computeFor;
import static com.github.speisz.euler.problem4.CartesianProduct.computeForStreams;

public class CartesianProductTest {

    @Test
    public void buildsCartesianForTwoOneElementCollections() {
        List<Pair<String>> product = computeFor(singletonList("a"), singletonList("b"));
        assertThat(product, hasSize(1));
        assertThat(product, hasItem(Pair.of("a", "b")));
    }

    @Test
    public void buildsCartesianForTwoArbitraryCollections() {
        List<Pair<String>> product = computeFor(asList("a", "b"), asList("a", "d", "e"));
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
    public void buildsCartesianStreamForTwoArbitraryStreams() {
        List<Pair<String>> product = computeForStreams(() -> Stream.of("a", "b"), () -> Stream.of("a", "d", "e")).collect(toList());
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
