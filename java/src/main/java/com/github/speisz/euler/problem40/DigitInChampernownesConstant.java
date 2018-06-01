package com.github.speisz.euler.problem40;

import com.github.speisz.euler.utils.BoundedStream;
import org.apache.commons.lang3.tuple.Pair;

import java.util.stream.Stream;

import static com.github.speisz.euler.utils.MathUtil.digits;
import static com.github.speisz.euler.utils.StreamUtil.lastElement;
import static java.util.stream.Collectors.toList;

class DigitInChampernownesConstant {
    static int find(int digitPosition) {
        return lastElement(
                BoundedStream.of(Stream.iterate(Pair.of(1, 1), pair1 -> Pair.of(pair1.getLeft() + 1, pair1.getRight() + (int) digits(pair1.getLeft() + 1).count())))
                        .withBreakConditionInclusive(pair1 -> pair1.getRight() >= digitPosition)
                        .get())
                .map(pair -> findDigit(digitPosition, pair.getLeft(), pair.getRight()))
                .orElseThrow(RuntimeException::new);
    }

    private static Integer findDigit(int digitPosition, Integer numberAtTheEndContainingDigit, Integer overallDigitCount) {
        return digits(numberAtTheEndContainingDigit).boxed().collect(toList())
                .get((int) digits(numberAtTheEndContainingDigit).count() - 1 - (overallDigitCount - digitPosition));
    }
}
