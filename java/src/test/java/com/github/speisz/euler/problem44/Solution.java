package com.github.speisz.euler.problem44;

import com.github.speisz.euler.math.IsPentagonal;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.Optional;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.LongStream.iterate;

public class Solution {

    private IsPentagonal isLongPentagonal = IsPentagonal.create();

    @Test
    public void unsafeAssumingPairs() {
        Optional<Pair<Long, Long>> first = iterate(n(4793403817125L), i -> i + 1)
                .mapToObj(n -> Pair.of(nthPentagonal(n), nthPentagonal(n + 1)))
                .filter(pair -> isLongPentagonal.test(pair.getRight() - pair.getLeft()))
                .peek(pair -> System.out.println(String.format("a=%s, b=%s", pair.getLeft(), pair.getRight())))
                .filter(pair -> isLongPentagonal.test(2 * pair.getLeft() - pair.getRight()))
                .findFirst();
        System.out.println(first);
    }

    @Test
    public void ___() {
        System.out.println(
//                pentagonals()
//                .limit(10)
                pentagonals(87001)
                        .filter(this::pentagonalNumbersWithPentagonalSumExist)
                        .findFirst());
    }

    private LongStream pentagonals() {
        return iterate(1, i -> i + 1)
                .map(this::nthPentagonal);
    }

    private long nthPentagonal(long n) {
        return (n * (3 * n - 1)) / 2;
    }

    private LongStream pentagonals(long lowerBound) {
        return iterate(n(lowerBound), i -> i + 1)
                .map(this::nthPentagonal);
    }

    private Stream<Pair<Long, Long>> pentagonalsIndexed(long lowerBound) {
        return iterate(n(lowerBound), i -> i + 1)
                .mapToObj(n -> Pair.of(n, nthPentagonal(n)));
    }

    private long n(long pentagonal) {
        return (1 + (long) Math.sqrt(1 + 24 * pentagonal)) / 6;
    }

    private boolean pentagonalNumbersWithPentagonalSumExist(Long difference) {
        return pentagonalsIndexed(difference)
                .takeWhile(pentagonal -> distanceToNextPentagonal(pentagonal.getKey()) <= difference)
                .parallel()
                .map(Pair::getValue)
                .filter(pentagonal -> isLongPentagonal.test(pentagonal + difference))
                .peek(pentagonal -> System.out.println(String.format("d=%s, p=%s", difference, pentagonal)))
                .anyMatch(pentagonal -> isLongPentagonal.test(2 * pentagonal + difference));
    }

    private Long distanceToNextPentagonal(Long n) {
        return 3 * n + 1;
    }
}
