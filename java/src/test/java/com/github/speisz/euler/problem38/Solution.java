package com.github.speisz.euler.problem38;

import com.github.speisz.euler.math.IsPandigital;
import org.junit.Test;

import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {

    @Test
    public void findsLargestOneToNinePandigitalConcatenatedProduct() {
        assertThat(IntStream.rangeClosed(9234, 9876)
                        .mapToLong(ConcatenatedProduct.of(asList(1, 2)))
                        .filter(IsPandigital.asLongPredicate())
//                        .peek(System.out::println)
                        .max()
                        .orElseGet(this::someKnownOneToNinePandigitalConcatenatedProduct),
                is(932718654L));
    }

    private long someKnownOneToNinePandigitalConcatenatedProduct() {
        return ConcatenatedProduct.of(9, asList(1, 2, 3, 4, 5));
    }
}
