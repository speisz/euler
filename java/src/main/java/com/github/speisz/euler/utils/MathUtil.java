package com.github.speisz.euler.utils;

import org.apache.commons.lang3.tuple.Triple;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static com.github.speisz.euler.utils.StreamUtil.lastElement;
import static java.lang.Math.floor;
import static java.lang.Math.sqrt;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;
import static java.util.stream.IntStream.generate;
import static java.util.stream.Stream.iterate;

public abstract class MathUtil {

    private MathUtil() {
    }

    public static final BigInteger TWO = valueOf(2);

    public static boolean isEven(BigInteger n) {
        return isDivisible(n, BigInteger.valueOf(2));
    }

    public static boolean isEven(long n) {
        return isDivisible(n, 2);
    }

    public static boolean lowerOrEqual(BigInteger n, BigInteger m) {
        return n.compareTo(m) < 1;
    }

    public static boolean greaterOrEqual(BigInteger n, BigInteger m) {
        return n.compareTo(m) > -1;
    }

    public static boolean isPythagorean(Triple<Integer, Integer, Integer> triple) {
        return isPythagorean(triple.getLeft(), triple.getMiddle(), triple.getRight());
    }

    public static boolean isPythagorean(Integer a, Integer b, Integer c) {
        return square(a) + square(b) == square(c);
    }

    public static BigInteger findNextPrime(List<BigInteger> primes) {
        if (primes.isEmpty()) {
            return TWO;
        }
        if (primes.size() == 1) {
            return valueOf(3);
        }
        return iterate(primes.get(primes.size() - 1).add(TWO), m -> m.add(TWO))
                .filter(m -> isNotDivisibleByAny(m, primes))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Number of primes is not infinite?!"));
    }

    private static boolean isNotDivisibleByAny(BigInteger number, List<BigInteger> potentialDivisors) {
        return potentialDivisors.stream().noneMatch(divisor -> isDivisible(number, divisor));
    }

    public static boolean isDivisible(BigInteger divident, BigInteger divisor) {
        return divident.mod(divisor).equals(ZERO);
    }

    public static int square(int n) {
        return (int) square((long) n);
    }

    public static long square(long n) {
        return n * n;
    }

    public static boolean isPrime(BigInteger n) {
        if (n.equals(TWO)) {
            return true;
        }
        return !lowerOrEqual(n, ONE) && iterate(TWO, ONE::add)
                .takeWhile(current -> lowerOrEqual(current, roundedSqrt(n)))
                .noneMatch(current -> isDivisible(n, current));
    }

    public static BigInteger roundedSqrt(BigInteger n) {
        BigInteger div = BigInteger.ZERO.setBit(n.bitLength() / 2);
        return roundedSqrtIteration(n, div, div);
    }

    private static BigInteger roundedSqrtIteration(BigInteger n, BigInteger div, BigInteger oldDiv) {
        BigInteger newDiv = div.add(n.divide(div)).shiftRight(1);
        if (newDiv.equals(div) || newDiv.equals(oldDiv)) {
            return newDiv;
        }
        return roundedSqrtIteration(n, newDiv, div);
    }

    public static boolean isPrime(long n) {
        return n > 1 && LongStream.rangeClosed(2, flooredSqrt(n)).noneMatch(k -> isDivisible(n, k));
    }

    public static boolean isDivisible(long divident, long divisor) {
        return divident % divisor == 0;
    }

    private static int flooredSqrt(double n) {
        return (int) floor(sqrt(n));
    }

    public static int pow(int base, int exponent) {
        return generate(() -> base)
                .limit(exponent)
                .reduce(1, (k, l) -> k * l);
    }

    public static BigInteger[] bigIntegerValuesOf(Integer... integers) {
        return Stream.of(integers).map(BigInteger::valueOf).toArray(BigInteger[]::new);
    }

    public static IntStream digits(BigInteger n) {
        return digits(n.toString());
    }

    public static IntStream digits(long n) {
        return digits(String.valueOf(n));
    }

    private static IntStream digits(String string) {
        return string
                .chars()
                .map(Character::getNumericValue);
    }

    public static boolean isPerfectSquare(int n) {
        return isPerfectSquare((long) n);
    }

    public static boolean isPerfectSquare(long n) {
        long firstSquareNotLowerThanN = lastElement(
                iterate(1L, i -> i + 1L)
                        .map(MathUtil::square)
                        .takeWhile(i -> i <= n))
                .orElseThrow(RuntimeException::new);
        return firstSquareNotLowerThanN == n;
    }
}
