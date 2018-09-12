package com.github.speisz.euler.problem._0._0._8;

import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class LargestProductInSeries {
    private String series;

    LargestProductInSeries(String series) {
        this.series = series;
    }

    long ofDigits(int digitCount) {
        if (digitCount > series.length()) {
            throw new IllegalArgumentException("Digit count has to be <= length(" + series + ")");
        }
        OptionalLong maxProduct = computeLargestProduct(digitCount);
        if (!maxProduct.isPresent()) {
            throw new IllegalArgumentException("Could not compute any product in " + series);
        }
        return maxProduct.getAsLong();
    }

    private OptionalLong computeLargestProduct(int digitCount) {
        return productStream(digitCount).max();
    }

    private LongStream productStream(int digitCount) {
        return IntStream.rangeClosed(0, series.length() - digitCount + 1)
                .mapToLong(startPosition -> series.substring(startPosition)
                        .chars()
                        .limit(digitCount)
                        .map(Character::getNumericValue)
                        .asLongStream()
                        .reduce(1, (left, right) -> left * right));
    }
}
