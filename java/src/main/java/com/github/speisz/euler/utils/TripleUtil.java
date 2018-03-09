package com.github.speisz.euler.utils;

import org.apache.commons.lang3.tuple.Triple;

public class TripleUtil {
    public static <L, M, R> Triple<R, M, L> swapLeftAndRight(Triple<L, M, R> triple) {
        return Triple.of(triple.getRight(), triple.getMiddle(), triple.getLeft());
    }
}
