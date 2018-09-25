package com.github.speisz.euler.problem._0._5._4;

import com.github.speisz.euler.problem._0._5._4.pokerrank.PokerRank;

public class PokerScore {
    public PokerScore(PokerHand pokerHand) {

    }

    public static PokerScore of(String handString) {
        return new PokerScore(PokerHand.of(handString));
    }

    public PokerRank getRank() {
        return null;
    }

}
