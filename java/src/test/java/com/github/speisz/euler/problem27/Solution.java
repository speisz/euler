package com.github.speisz.euler.problem27;

import com.github.speisz.euler.math.QuadraticForm;
import org.junit.Test;

import java.util.stream.Stream;

import static com.github.speisz.euler.utils.MathUtil.isPrime;
import static com.github.speisz.euler.utils.StreamUtil.max;
import static com.github.speisz.euler.utils.StreamUtil.pairStream;
import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {

    @Test
    public void findsProductOfCoefficientsWithMaximumNumberOfConsecutivePrimes() {
        Stream<QuadraticForm> quadraticForms = pairStream(() -> rangeClosed(-999, 999).boxed())
                .filter(coefficients -> isPrime(coefficients.getRight())) // optimization only
                .map(QuadraticForm::withCoefficients);

        assertThat(max(quadraticForms, NumberOfConsecutivePrimes::of)
                .map(QuadraticForm::coefficientProduct)
                .orElseThrow(RuntimeException::new), is(-59231));
    }
}
