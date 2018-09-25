package com.github.speisz.euler.problem._0._5._4.pokerrank;

import com.github.speisz.euler.problem._0._5._4.PokerHand;

import java.util.Optional;

public abstract class PokerRankFinder {

    protected PokerHand hand;

    public Optional<PokerRank> getRank() {
        if (!isResponsible()) {
            return next().map(PokerRankFinder::determineRank);
        }
        return Optional.of(determineRank());
    }

    Optional<PokerRankFinder> next() {
        return Optional.empty();
    }

    protected abstract PokerRank determineRank();

    abstract boolean isResponsible();
}
