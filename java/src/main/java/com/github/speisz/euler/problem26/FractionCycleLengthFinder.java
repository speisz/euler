package com.github.speisz.euler.problem26;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;
import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;

class FractionCycleLengthFinder {
    static int findFor(int denominator) {
        return determineCycleLength(10, denominator, IntermediateResult.create()).getCycleLength();
    }

    private static IntermediateResult determineCycleLength(int numerator, int denominator, IntermediateResult result) {
        int quotient = numerator / denominator;
        result.addToQuotient(quotient);
        if (quotient == 0) {
            return determineCycleLength(10 * numerator, denominator, result.incrementCycleLength());
        }
        int remainder = numerator % denominator;
        if (remainder == 0) {
            return result.resetCycleLength();
        }
        if (result.remainderAlreadyOccurred(remainder)) {
            return result;
        }
        result.addRemainder(remainder);
        return determineCycleLength(10 * remainder, denominator, result.incrementCycleLength());
    }

    static class IntermediateResult {
        private final Set<Integer> remainders;
        private final List<Integer> quotient;
        private int cycleLength;

        private IntermediateResult() {
            cycleLength = 0;
            remainders = newHashSet();
            quotient = newArrayList();
        }

        static IntermediateResult create() {
            return new IntermediateResult();
        }

        IntermediateResult incrementCycleLength() {
            cycleLength++;
            return this;
        }

        int getCycleLength() {
            return cycleLength;
        }

        IntermediateResult resetCycleLength() {
            cycleLength = 0;
            return this;
        }

        boolean remainderAlreadyOccurred(int remainder) {
            return remainders.contains(remainder);
        }

        void addRemainder(int remainder) {
            remainders.add(remainder);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.NO_CLASS_NAME_STYLE)
                    .append("remainders", remainders)
                    .append("cycleLength", cycleLength)
                    .append("quotient", quotient)
                    .toString();
        }

        void addToQuotient(int quotientDigit) {
            quotient.add(quotientDigit);
        }
    }
}
