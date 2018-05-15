package com.github.speisz.euler.problem36;

import com.github.speisz.euler.utils.IntegerPalindromeCheck;
import com.github.speisz.euler.utils.StringPalindromeCheck;
import org.junit.Test;

import static java.util.stream.IntStream.rangeClosed;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {

    @Test
    public void findsAllDoubleBasePalindromesUpToOneMillion() {
        assertThat(rangeClosed(0, 1_000_000).boxed()
                .filter(IntegerPalindromeCheck.create())
                .filter(n -> StringPalindromeCheck.create().test(Integer.toBinaryString(n)))
//                .peek(System.out::println)
                .mapToInt(n -> n)
                .sum(), is(872187));
    }
}
