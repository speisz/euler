package com.github.speisz.euler.problem._0._3._6;

import com.github.speisz.euler.utils.IntegerPalindromeCheck;
import com.github.speisz.euler.utils.StringPalindromeCheck;
import org.junit.jupiter.api.Test;

import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    @Test
    void findsAllDoubleBasePalindromesUpToOneMillion() {
        assertThat(rangeClosed(0, 1_000_000).boxed()
                .filter(IntegerPalindromeCheck.create())
                .filter(n -> StringPalindromeCheck.create().test(Integer.toBinaryString(n)))
//                .peek(System.out::println)
                .mapToInt(n -> n)
                .sum(), is(872187));
    }
}
