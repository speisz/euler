package com.github.speisz.euler.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ByteUtil {

    public static String toBinaryString(int bite) {
        return String.format("%8s", Integer.toBinaryString(bite & 0xFF)).replace(' ', '0');
    }

    public static byte[] toByteArray(IntStream stream) {
        return stream.collect(ByteArrayOutputStream::new, ByteArrayOutputStream::write, ByteUtil::appendTo)
                .toByteArray();
    }

    public static byte[] toByteArray(Stream<Byte> stream) {
        return stream.collect(ByteArrayOutputStream::new, ByteArrayOutputStream::write, ByteUtil::appendTo)
                .toByteArray();
    }

    private static void appendTo(ByteArrayOutputStream first, ByteArrayOutputStream second) {
        try {
            second.writeTo(first);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] toByteArray(Integer... integers) {
        return toByteArray(Stream.of(integers).mapToInt(n -> n));
    }
}
