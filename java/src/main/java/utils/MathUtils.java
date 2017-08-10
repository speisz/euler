package utils;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;

public class MathUtils {
    public static boolean isEven(BigInteger value) {
        return value.mod(BigInteger.valueOf(2L)).equals(ZERO);
    }

    public static boolean lowerOrEqual(BigInteger first, BigInteger second) {
        return first.compareTo(second) < 1;
    }
}
