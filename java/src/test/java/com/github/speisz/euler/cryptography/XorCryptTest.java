package com.github.speisz.euler.cryptography;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

class XorCryptTest {

    private static final String MESSAGE = "message";
    private static final String KEY_SAME_LENGTH = "key1234";
    private static final String SHORTER_KEY = "key";
    private static final String LONGER_KEY = "key123456789";

    @Test
    void encryptsWithSameLengthKey() {
        assertTrue(Arrays.equals(XorCrypt.encrypt(MESSAGE, KEY_SAME_LENGTH), new byte[]{6, 0, 10, 66, 83, 84, 81}));
    }

    @Test
    void decryptsWithSameLengthKey() {
        assertThat(XorCrypt.decrypt(new byte[]{6, 0, 10, 66, 83, 84, 81}, KEY_SAME_LENGTH), is(MESSAGE));
    }

    @Test
    void encryptsWithArbitraryKey() {
        assertTrue(Arrays.equals(XorCrypt.encrypt(MESSAGE, SHORTER_KEY), new byte[]{6, 0, 10, 24, 4, 30, 14}));
        assertTrue(Arrays.equals(XorCrypt.encrypt(MESSAGE, LONGER_KEY), new byte[]{6, 0, 10, 66, 83, 84, 81}));
    }

    @Test
    void decryptsWithArbitraryKey() {
        assertThat(XorCrypt.decrypt(new byte[]{6, 0, 10, 24, 4, 30, 14}, SHORTER_KEY), is(MESSAGE));
        assertThat(XorCrypt.decrypt(new byte[]{6, 0, 10, 66, 83, 84, 81}, LONGER_KEY), is(MESSAGE));
    }
}
