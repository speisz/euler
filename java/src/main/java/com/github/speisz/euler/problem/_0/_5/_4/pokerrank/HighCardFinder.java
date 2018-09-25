package com.github.speisz.euler.problem._0._5._4.pokerrank;

public class HighCardFinder extends PokerRankFinder {

    public static final HighCardFinder INSTANCE = new HighCardFinder();

    @Override
    protected PokerRank determineRank() {
        return HighCard.of(hand);
    }

    @Override
    boolean isResponsible() {
        return true;
    }
}
