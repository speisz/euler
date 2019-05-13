package com.github.speisz.euler.problem._0._4._5;

import com.github.speisz.euler.math.polygonal.IsHexagonal;
import com.github.speisz.euler.math.polygonal.IsPentagonal;
import org.junit.jupiter.api.Test;

import java.util.OptionalLong;
import java.util.function.LongPredicate;
import java.util.stream.LongStream;

import static com.github.speisz.euler.testutils.matcher.optionallong.HasValueMatcher.hasValue;
import static org.hamcrest.MatcherAssert.assertThat;

class Solution {

    private static final LongPredicate IS_PENTAGONAL = IsPentagonal.create().toLongPredicate();
    private static final LongPredicate IS_HEXAGONAL = IsHexagonal.create().toLongPredicate();

    @Test
    void findsSecondNumberThatIsTrianglePentagonalAndHexagonal() {
        OptionalLong trianglePentagonalHexagonal = LongStream.iterate(286, n -> n + 1)
                .map(this::nthTriangle)
                .filter(IS_PENTAGONAL)
                .filter(IS_HEXAGONAL)
                .findFirst();

        assertThat(trianglePentagonalHexagonal, hasValue(1_533_776_805L));
    }

    private long nthTriangle(long n) {
        return (n * (n + 1)) / 2;
    }
}
