package com.github.speisz.euler.problem._0._5._4.pokerrank;

import com.github.speisz.euler.problem._0._5._4.PokerCard;
import com.github.speisz.euler.problem._0._5._4.PokerHand;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class OnePairTest {

    @Test
    void findsOnePair() {
        assertThat(OnePair.of(
                PokerHand.of(asList(
                        PokerCard.of(PokerCard.Value.FIVE, PokerCard.Color.D),
                        PokerCard.of(PokerCard.Value.KING, PokerCard.Color.C),
                        PokerCard.of(PokerCard.Value.KING, PokerCard.Color.D),
                        PokerCard.of(PokerCard.Value.TWO, PokerCard.Color.S),
                        PokerCard.of(PokerCard.Value.FIVE, PokerCard.Color.S)))).secondaryValue,
                is(PokerCard.Value.KING.numericValue()));
    }
}
