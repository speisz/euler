package com.github.speisz.euler.problem34;

import com.github.speisz.euler.math.LazyFactorialComputation;
import org.junit.Test;

import static com.github.speisz.euler.utils.MathUtil.digits;
import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {

    private LazyFactorialComputation factorialComputation = new LazyFactorialComputation();

    @Test
    public void findsSumOfNumbersEqualToTheirDigitFactorialSum() {
        assertThat(rangeClosed(3, 7 * factorial(9))
                .filter(n -> n == digitFactorialSum(n))
                .sum(), is(40730));
    }

    private int digitFactorialSum(int n) {
        return digits(n).map(this::factorial).sum();
    }

    private int factorial(int n) {
        return factorialComputation.of(n).intValue();
    } 
}
