package com.github.speisz.euler.utils;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.github.speisz.euler.utils.StreamUtil.descendingPairStream;
import static com.github.speisz.euler.utils.StreamUtil.descendingTripleStream;
import static com.github.speisz.euler.utils.StreamUtil.streamBuilderFrom;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class StreamUtilTest {

    @Test
    public void createsStreamOfDescendingPositiveIntegerPairs() {
        assertThat(descendingPairStream(IntStream.of(2, 4)).collect(toList()), contains(
                Pair.of(2, 1),
                Pair.of(4, 1),
                Pair.of(4, 2),
                Pair.of(4, 3)));
    }

    @Test
    public void createsStreamOfDescendingPositiveIntegerTriples() {
        assertThat(
                descendingTripleStream(Stream.of(
                        Pair.of(3, 2),
                        Pair.of(4, 3),
                        Pair.of(3, 4))).collect(toList()),
                contains(
                        Triple.of(3, 2, 1),
                        Triple.of(4, 3, 1),
                        Triple.of(4, 3, 2),
                        Triple.of(3, 4, 1),
                        Triple.of(3, 4, 2),
                        Triple.of(3, 4, 3)));
    }

    @Test
    public void createsStreamBuilderFromStream() {
        assertThat(streamBuilderFrom(Stream.of("1")).build().collect(toList()), contains("1"));
    }

    @Test
    public void createsIntStreamBuilderFromIntStream() {
        assertThat(streamBuilderFrom(IntStream.of(1)).build().boxed().collect(toList()), contains(1));
    }
}
