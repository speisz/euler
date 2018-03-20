package com.github.speisz.euler.problem17;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WordOfNumberTest {
    @Test
    public void getsWordsOfDigits() {
        MatcherAssert.assertThat(WordOfNumber.get(0), is(""));
        assertThat(WordOfNumber.get(1), is("one"));
        assertThat(WordOfNumber.get(2), is("two"));
        assertThat(WordOfNumber.get(3), is("three"));
        assertThat(WordOfNumber.get(4), is("four"));
        assertThat(WordOfNumber.get(5), is("five"));
        assertThat(WordOfNumber.get(6), is("six"));
        assertThat(WordOfNumber.get(7), is("seven"));
        assertThat(WordOfNumber.get(8), is("eight"));
        assertThat(WordOfNumber.get(9), is("nine"));
    }

    @Test
    public void getsWordsOfHundreds() {
        assertThat(WordOfNumber.get(100), is("onehundred"));
        assertThat(WordOfNumber.get(200), is("twohundred"));
        assertThat(WordOfNumber.get(300), is("threehundred"));
        assertThat(WordOfNumber.get(400), is("fourhundred"));
        assertThat(WordOfNumber.get(500), is("fivehundred"));
        assertThat(WordOfNumber.get(600), is("sixhundred"));
        assertThat(WordOfNumber.get(700), is("sevenhundred"));
        assertThat(WordOfNumber.get(800), is("eighthundred"));
        assertThat(WordOfNumber.get(900), is("ninehundred"));
    }

    @Test
    public void getsWordsOfThousands() {
        assertThat(WordOfNumber.get(1000), is("onethousand"));
        assertThat(WordOfNumber.get(2000), is("twothousand"));
        assertThat(WordOfNumber.get(3000), is("threethousand"));
        assertThat(WordOfNumber.get(4000), is("fourthousand"));
        assertThat(WordOfNumber.get(5000), is("fivethousand"));
        assertThat(WordOfNumber.get(6000), is("sixthousand"));
        assertThat(WordOfNumber.get(7000), is("seventhousand"));
        assertThat(WordOfNumber.get(8000), is("eightthousand"));
        assertThat(WordOfNumber.get(9000), is("ninethousand"));
    }

    @Test
    public void getsWordsOfTens() {
        assertThat(WordOfNumber.get(10), is("ten"));
        assertThat(WordOfNumber.get(20), is("twenty"));
        assertThat(WordOfNumber.get(30), is("thirty"));
        assertThat(WordOfNumber.get(40), is("forty"));
        assertThat(WordOfNumber.get(50), is("fifty"));
        assertThat(WordOfNumber.get(60), is("sixty"));
        assertThat(WordOfNumber.get(70), is("seventy"));
        assertThat(WordOfNumber.get(80), is("eighty"));
        assertThat(WordOfNumber.get(90), is("ninety"));
    }

    @Test
    public void getsRegularCombinedWordsUpToHundred() {
        assertThat(WordOfNumber.get(23), is("twentythree"));
        assertThat(WordOfNumber.get(34), is("thirtyfour"));
        assertThat(WordOfNumber.get(99), is("ninetynine"));
    }

    @Test
    public void getsRegularCombinedWords() {
        assertThat(WordOfNumber.get(102), is("onehundredandtwo"));
        assertThat(WordOfNumber.get(123), is("onehundredandtwentythree"));
        assertThat(WordOfNumber.get(234), is("twohundredandthirtyfour"));
        assertThat(WordOfNumber.get(999), is("ninehundredandninetynine"));
    }

    @Test
    public void getsWordsForExceptionalCases() {
        assertThat(WordOfNumber.get(11), is("eleven"));
        assertThat(WordOfNumber.get(12), is("twelve"));
        assertThat(WordOfNumber.get(13), is("thirteen"));
        assertThat(WordOfNumber.get(14), is("fourteen"));
        assertThat(WordOfNumber.get(15), is("fifteen"));
        assertThat(WordOfNumber.get(16), is("sixteen"));
        assertThat(WordOfNumber.get(17), is("seventeen"));
        assertThat(WordOfNumber.get(18), is("eighteen"));
        assertThat(WordOfNumber.get(19), is("nineteen"));
    }
}
