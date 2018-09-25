package com.github.speisz.euler.problem._0._5._4.pokerrank;

import com.github.speisz.euler.problem._0._5._4.PokerCard;
import com.github.speisz.euler.problem._0._5._4.PokerHand;

public class HighCard extends PokerRank {
    private HighCard(PokerHand hand) {
        secondaryValue = hand.stream()
                .map(PokerCard::getValue)
                .mapToInt(PokerCard.Value::numericValue)
                .max().orElseThrow();
    }

    public static HighCard of(PokerHand hand) {
        return new HighCard(hand);
    }

    @Override
    int getPrimaryValue() {
        return 0;
    }
}
