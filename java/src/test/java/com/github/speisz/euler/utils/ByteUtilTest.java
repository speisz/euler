package com.github.speisz.euler.utils;

import org.junit.jupiter.api.Test;

import static com.github.speisz.euler.utils.ByteUtil.toBinaryString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class ByteUtilTest {

    @Test
    void computesBinaryStringRepresentation() {
        assertThat(toBinaryString(0), is("00000000"));
        assertThat(toBinaryString(1), is("00000001"));
        assertThat(toBinaryString(2), is("00000010"));
        assertThat(toBinaryString(3), is("00000011"));
        assertThat(toBinaryString(8), is("00001000"));
        assertThat(toBinaryString(42), is("00101010"));
        assertThat(toBinaryString(65), is("01000001"));
        assertThat(toBinaryString(107), is("01101011"));
        assertThat(toBinaryString(255), is("11111111"));
    }
}
