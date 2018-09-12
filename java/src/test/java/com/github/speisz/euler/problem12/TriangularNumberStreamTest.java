package com.github.speisz.euler.problem12;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static java.math.BigInteger.valueOf;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class TriangularNumberStreamTest {

    @Test
    void suppliesTriangularNumbers() {
        assertThat(firstNTriangularNumbers(1), is(singletonList(valueOf(1))));
        assertThat(firstNTriangularNumbers(2), is(asList(valueOf(1), valueOf(3))));
        assertThat(firstNTriangularNumbers(3), is(asList(valueOf(1), valueOf(3), valueOf(6))));
        assertThat(firstNTriangularNumbers(4), is(asList(valueOf(1), valueOf(3), valueOf(6), valueOf(10))));
    }

    private List<BigInteger> firstNTriangularNumbers(int n) {
        return new TriangularNumberStream().get()
                .limit(n)
                .collect(toList());
    }
}
