package com.github.speisz.euler.problem40;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DigitInChampernownesConstantTest {

    @Test
    public void findsDigitInChampernownesConstant() {
        assertThat(DigitInChampernownesConstant.find(1), is(1));
        assertThat(DigitInChampernownesConstant.find(5), is(5));
        assertThat(DigitInChampernownesConstant.find(10), is(1));
        assertThat(DigitInChampernownesConstant.find(11), is(0));
        assertThat(DigitInChampernownesConstant.find(15), is(2));
    }
}