package com.github.speisz.euler.cryptography;

import static com.github.speisz.euler.utils.ByteUtil.toByteArray;
import static java.util.stream.IntStream.range;

public class XorCrypt {
    public static byte[] encrypt(String message, String key) {
        return xor(message.getBytes(), key.getBytes());
    }

    public static String decrypt(byte[] encrypted, String key) {
        return new String(xor(encrypted, key.getBytes()));
    }

    private static byte[] xor(byte[] bytes, byte[] keyBytes) {
        return toByteArray(range(0, bytes.length).map(index -> bytes[index] ^ keyBytes[index % keyBytes.length]));
    }
}
