package com.github.speisz.euler.problem28;

import static java.util.stream.IntStream.rangeClosed;

class VertexSum {
    static int computeForIndex(int index) {
        return 4 + rangeClosed(0, index - 1)
                .map(VertexSum::difference)
                .sum();
    }

    private static int difference(int index) {
        return 32 * index + 20;
    }
}
