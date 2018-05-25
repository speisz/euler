package com.github.speisz.euler.problem38;

import java.util.List;
import java.util.function.IntToLongFunction;

import static com.github.speisz.euler.utils.LongUtil.concat;
import static com.github.speisz.euler.utils.LongUtil.identity;

public class ConcatenatedProduct {

    public static long of(int n, List<Integer> factors) {
        return concat(factors.stream().mapToLong(identity()).map(m -> n * m));
    }

    public static IntToLongFunction of(List<Integer> factors) {
        return n -> concat(factors.stream().mapToLong(identity()).map(m -> n * m));
    }
}
