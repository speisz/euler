package com.github.speisz.euler.problem._0._0._9;

import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static com.github.speisz.euler.utils.MathUtil.isPythagorean;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PythagoreanTripleStreamTest {

    private PythagoreanTripleStream pythagoreanTripleStream = new PythagoreanTripleStream();

    @Test
    void findsFirstPythagoreanTriple() {
        Optional<Triple<Integer, Integer, Integer>> pythagoreanTriple = pythagoreanTripleStream.get().findFirst();

        assertThat(pythagoreanTriple.isPresent(), is(true));
        pythagoreanTriple.ifPresent(triple -> assertThat(triple, is(Triple.of(3, 4, 5))));
    }

    @Test
    void findsFirstNPythagoreanTriples() {
        List<Triple<Integer, Integer, Integer>> pythagoreanTriples = pythagoreanTripleStream.get().limit(4).collect(toList());

        assertThat(pythagoreanTriples, hasSize(4));
        assertThat(pythagoreanTriples, contains(
                Triple.of(3, 4, 5),
                Triple.of(6, 8, 10),
                Triple.of(5, 12, 13),
                Triple.of(9, 12, 15)
        ));
    }

    @Test
    void findsManyPythagoreanTriples() {
        int n = 1000;
        List<Triple<Integer, Integer, Integer>> pythagoreanTriples = pythagoreanTripleStream.get().limit(n).collect(toList());

        assertThat(pythagoreanTriples, hasSize(n));
        pythagoreanTriples.forEach(triple -> assertTrue(isPythagorean(triple)));
    }
}
