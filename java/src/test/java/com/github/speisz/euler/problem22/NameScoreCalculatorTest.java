package com.github.speisz.euler.problem22;

import org.junit.Test;

import java.math.BigInteger;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NameScoreCalculatorTest {

    private WordValueCalculator wordValueCalculator = mock(WordValueCalculator.class);

    @Test
    public void calculatesScoresBasedOnPositionInSortedList() {
        NameScoreCalculator nameScoreCalculator = NameScoreCalculator.create(wordValueCalculator);
        when(wordValueCalculator.calculateFor("A")).thenReturn(7);
        when(wordValueCalculator.calculateFor("B")).thenReturn(11);
        when(wordValueCalculator.calculateFor("C")).thenReturn(13);

        BigInteger score = nameScoreCalculator.calculate(asList("B", "A", "C"));

        assertThat(score, is(BigInteger.valueOf(7 + 2 * 11 + 3 * 13)));
    }
}
