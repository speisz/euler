package com.github.speisz.euler.problem9;

import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class TripleProductTest {

    @Test
    void findsFirstTripleProduct() {
        int product = new TripleProduct(() -> Stream.of(Triple.of(3, 4, 5))).computeFirst();

        assertThat(product, is(3 * 4 * 5));
    }

    @Test
    void findsPythagoreanTripleProductForGivenCondition() {
        Predicate<Triple<Integer, Integer, Integer>> condition = triple -> triple.getLeft() + triple.getMiddle() + triple.getRight() == 1000;

        int product = new TripleProduct(new PythagoreanTripleStream()).computeFirst(condition);

        assertThat(product, is(31_875_000));
    }
}
