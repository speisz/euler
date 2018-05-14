package com.github.speisz.euler.problem34;

import com.github.speisz.euler.utils.Factorial;
import org.junit.Test;

import java.util.Map;

import static com.github.speisz.euler.utils.MathUtil.digits;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {

    private static Map<Integer, Integer> digitFactorials = rangeClosed(0, 9).boxed()
            .collect(toMap(n -> n, n -> Factorial.of(n).intValue()));

    @Test
    public void findsSumOfNumbersEqualToTheirDigitFactorialSum() {
        assertThat(rangeClosed(3, 7 * digitFactorials.get(9))
                .filter(n -> n == digitFactorialSum(n))
                .sum(), is(40730));
    }

    private int digitFactorialSum(int n) {
        return digits(n).map(digitFactorials::get).sum();
    }
}
