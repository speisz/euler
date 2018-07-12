package com.github.speisz.euler.problem40;

import static com.github.speisz.euler.utils.MathUtil.digits;
import static com.github.speisz.euler.utils.StreamUtil.lastElement;
import static com.github.speisz.euler.utils.StreamUtil.nthElement;
import static java.util.stream.Stream.iterate;

class DigitInChampernownesConstant {
    static int find(int indexOfDigit) {
        return lastElement(iterate(Position.of(indexOfDigit), Position::moveToNextNumber).takeWhile(Position::isNotAfter))
                .map(Position::findDigit)
                .orElseThrow(RuntimeException::new);
    }

    static class Position {
        private Integer findDigit() {
            return nthElement(digits(numberAtTheEndContainingDigit).boxed(), (int) digits(numberAtTheEndContainingDigit).count() - (overallDigitCount - indexOfDigit))
                    .orElseThrow(() -> new IllegalStateException("Position determination must have failed."));
        }

        private boolean isAtCorrectNumber() {
            return overallDigitCount >= indexOfDigit;
        }

        private Position moveToNextNumber() {
            return new Position(numberAtTheEndContainingDigit + 1, this.overallDigitCount + (int) digits(numberAtTheEndContainingDigit + 1).count(), indexOfDigit, isAtCorrectNumber());
        }

        private int numberAtTheEndContainingDigit;
        private int overallDigitCount;
        private int indexOfDigit;
        private boolean isAfterDigit;

        private Position(int numberAtTheEndContainingDigit, int overallDigitCount, int indexOfDigit, boolean isAfterDigit) {
            this.numberAtTheEndContainingDigit = numberAtTheEndContainingDigit;
            this.overallDigitCount = overallDigitCount;
            this.indexOfDigit = indexOfDigit;
            this.isAfterDigit = isAfterDigit;
        }

        public static Position of(int indexOfDigit) {
            return new Position(1, 1, indexOfDigit, false);
        }

        boolean isNotAfter() {
            return !isAfterDigit;
        }
    }
}
