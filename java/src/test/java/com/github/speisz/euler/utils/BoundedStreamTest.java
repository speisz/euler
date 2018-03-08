package com.github.speisz.euler.utils;

import org.junit.Test;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.iterate;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class BoundedStreamTest {
    @Test
    public void createsStreamWithGivenExclusiveCondition() {
        assertThat(BoundedStream.of(iterate(1, n -> n + 1))
                .withConditionExclusive(n -> n < 4)
                .get()
                .collect(toList()), contains(1, 2, 3));
    }
    @Test
    public void createsStreamWithGivenInclusiveCondition() {
        assertThat(BoundedStream.of(iterate(1, n -> n + 1))
                .withConditionInclusive(n -> n != 4)
                .get()
                .collect(toList()), contains(1, 2, 3, 4));
    }
}
