package com.github.speisz.euler.utils;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.github.speisz.euler.testutils.matcher.OptionalMatchers.hasValue;
import static com.github.speisz.euler.utils.StreamUtil.descendingPairStream;
import static com.github.speisz.euler.utils.StreamUtil.descendingTripleStream;
import static com.github.speisz.euler.utils.StreamUtil.nthElement;
import static com.github.speisz.euler.utils.StreamUtil.pairStream;
import static com.github.speisz.euler.utils.StreamUtil.streamBuilderFrom;
import static java.util.stream.Collectors.toList;
import static java.util.stream.LongStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class StreamUtilTest {

    @Test
    void createsStreamOfPairs() {
        assertThat(pairStream(() -> Stream.of(2, 4)).collect(toList()), contains(
                Pair.of(2, 2),
                Pair.of(2, 4),
                Pair.of(4, 2),
                Pair.of(4, 4)));
    }

    @Test
    void createsStreamOfDescendingPositiveIntegerPairs() {
        assertThat(descendingPairStream(IntStream.of(2, 4)).collect(toList()), contains(
                Pair.of(2, 1),
                Pair.of(4, 1),
                Pair.of(4, 2),
                Pair.of(4, 3)));
    }

    @Test
    void createsStreamOfDescendingPositiveIntegerTriples() {
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
    void createsStreamBuilderFromStream() {
        assertThat(streamBuilderFrom(Stream.of("1")).build().collect(toList()), contains("1"));
    }

    @Test
    void createsIntStreamBuilderFromIntStream() {
        assertThat(streamBuilderFrom(IntStream.of(1)).build().boxed().collect(toList()), contains(1));
    }

    @Test
    void retrievesNthElementOfStream() {
        assertThat(nthElement(rangeClosed(1, 100_000_000L).boxed(), 50_000_000L), hasValue(50_000_000L));
    }
}
