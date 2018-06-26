package com.github.speisz.euler.problem43;

import com.github.speisz.euler.utils.LexicographicPermutations;
import org.apache.commons.lang3.Range;

import java.util.List;
import java.util.stream.LongStream;

import static java.lang.Integer.parseInt;
import static java.util.stream.IntStream.rangeClosed;

class SubstringDivisibleZeroNinePandigitals {

    private Range<Integer> positionRange;
    private int substringLength;
    private List<Integer> factors;

    SubstringDivisibleZeroNinePandigitals(Range<Integer> positionRange, int substringLength, List<Integer> factors) {
        assert positionRange.getMaximum() + substringLength - 1 <= 10;
        assert factors.size() == positionRange.getMaximum() - positionRange.getMinimum() + 1;
        this.positionRange = positionRange;
        this.substringLength = substringLength;
        this.factors = factors;
    }

    public LongStream stream() {
        return LexicographicPermutations.stream("0123456789")
                .filter(this::matchesSubstringDivisibilityCondition)
                .mapToLong(Long::parseLong);
    }

    private boolean matchesSubstringDivisibilityCondition(String numberString) {
        return rangeClosed(positionRange.getMinimum(), positionRange.getMaximum())
                .allMatch(position -> substringAtPositionIsDivisible(numberString, position));
    }

    private boolean substringAtPositionIsDivisible(String numberString, int position) {
        int divisor = factors.get(position - positionRange.getMinimum());
        int divident = parseInt(numberString.substring(position - 1, position - 1 + substringLength));
        return divident % divisor == 0;
    }
}
