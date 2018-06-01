package com.github.speisz.euler.utils;

import org.junit.Test;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.iterate;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class BoundedIntStreamTest {

    @Test
    public void createsIntStreamWithGivenExclusiveCondition() {
        assertThat(BoundedIntStream.of(iterate(1, n -> n + 1))
                .withConditionExclusive(n -> n < 4)
                .get()
                .boxed()
                .collect(toList()), contains(1, 2, 3));
    }

    @Test
    public void createsIntStreamWithGivenInclusiveCondition() {
        assertThat(BoundedIntStream.of(iterate(1, n -> n + 1))
                .withConditionInclusive(n -> n != 4)
                .get()
                .boxed()
                .collect(toList()), contains(1, 2, 3, 4));
    }

    @Test
    public void createsIntStreamWithGivenBreakCondition() {
        assertThat(BoundedIntStream.of(iterate(1, n -> n + 1))
                .withBreakConditionInclusive(n -> n == 4)
                .get()
                .boxed()
                .collect(toList()), contains(1, 2, 3, 4));
    }
}
