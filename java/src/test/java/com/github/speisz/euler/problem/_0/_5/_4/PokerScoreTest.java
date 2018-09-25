package com.github.speisz.euler.problem._0._5._4;

import com.github.speisz.euler.problem._0._5._4.pokerrank.HighCard;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

class PokerScoreTest {

    @Test
    void computesRanksCorrectly() {
        assertThat(PokerScore.of("5H 5C 6S 7S KD").getRank(), is(instanceOf(HighCard.class)));
    }
}
