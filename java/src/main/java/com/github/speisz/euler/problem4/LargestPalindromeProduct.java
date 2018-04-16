package com.github.speisz.euler.problem4;

import static java.util.stream.IntStream.rangeClosed;

class LargestPalindromeProduct {

    private IntegerPalindromeCheck palindromeCheck = new IntegerPalindromeCheck();

    int compute(int digits) {
        int upper = (int) (Math.pow(10, digits) - 1);
        return CartesianProduct.computeForStreams(() -> rangeClosed(1, upper).boxed(), () -> rangeClosed(1, upper).boxed())
                .parallel()
                .map(pair -> pair.getLeft() * pair.getRight())
                .filter(palindromeCheck)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("No palindrome products exist for two number of " + digits + " digits"));
    }
}
