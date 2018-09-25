package com.github.speisz.euler.problem._0._5._4.pokerrank;

import com.github.speisz.euler.problem._0._5._4.PokerCard;
import com.github.speisz.euler.problem._0._5._4.PokerHand;

import static java.lang.Integer.compare;

public abstract class PokerRank implements Comparable<PokerRank> {

    int secondaryValue;

    abstract int getPrimaryValue();

    public int getSecondaryValue() {
        return secondaryValue;
    }

    @Override
    public int compareTo(PokerRank other) {
        int primaryComparison = compare(getPrimaryValue(), other.getPrimaryValue());
        return primaryComparison != 0 ? primaryComparison : compare(getSecondaryValue(), other.getSecondaryValue());
    }

}
