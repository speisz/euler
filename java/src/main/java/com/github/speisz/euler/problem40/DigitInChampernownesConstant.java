package com.github.speisz.euler.problem40;

import com.github.speisz.euler.utils.BoundedStream;

import static com.github.speisz.euler.utils.MathUtil.digits;
import static com.github.speisz.euler.utils.StreamUtil.lastElement;
import static com.github.speisz.euler.utils.StreamUtil.nthElement;
import static java.util.stream.Stream.iterate;

class DigitInChampernownesConstant {
    static int find(int indexOfDigit) {
        return lastElement(
                BoundedStream.of(iterate(Position.of(indexOfDigit), Position::moveToNextNumber))
                        .withBreakConditionInclusive(Position::isAtCorrectNumber)
                        .get())
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
            return new Position(numberAtTheEndContainingDigit + 1, overallDigitCount + (int) digits(numberAtTheEndContainingDigit + 1).count(), indexOfDigit);
        }

        private int numberAtTheEndContainingDigit;
        private int overallDigitCount;
        private int indexOfDigit;

        private Position(int numberAtTheEndContainingDigit, int overallDigitCount, int indexOfDigit) {
            this.numberAtTheEndContainingDigit = numberAtTheEndContainingDigit;
            this.overallDigitCount = overallDigitCount;
            this.indexOfDigit = indexOfDigit;
        }

        public static Position of(int digitPosition) {
            return new Position(1, 1, digitPosition);
        }
    }
}
