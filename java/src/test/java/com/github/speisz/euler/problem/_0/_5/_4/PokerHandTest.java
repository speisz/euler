package com.github.speisz.euler.problem._0._5._4;

import org.junit.jupiter.api.Test;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

class PokerHandTest {

    @Test
    void parsesHand() {
        assertThat(PokerHand.of("5H 5C 6S 7S KD").stream().collect(toList()), hasItems(
                PokerCard.of(PokerCard.Value.FIVE, PokerCard.Color.H),
                PokerCard.of(PokerCard.Value.FIVE, PokerCard.Color.C),
                PokerCard.of(PokerCard.Value.SIX, PokerCard.Color.S),
                PokerCard.of(PokerCard.Value.SEVEN, PokerCard.Color.S),
                PokerCard.of(PokerCard.Value.KING, PokerCard.Color.D)));
    }
}
