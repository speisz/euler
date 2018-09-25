package com.github.speisz.euler.problem._0._5._4.pokerrank;

import com.github.speisz.euler.problem._0._5._4.PokerCard;
import com.github.speisz.euler.problem._0._5._4.PokerHand;

import java.util.Comparator;
import java.util.Map;
import java.util.function.BinaryOperator;

import static java.util.stream.Collectors.toMap;

public class OnePair extends PokerRank {

    private static final BinaryOperator<Integer> SUM = (i, j) -> i + j;

    public OnePair(PokerHand hand) {
        Map<PokerCard.Value, Integer> multiplicities = hand.stream()
                .collect(toMap(PokerCard::getValue, card -> 1, SUM));

        multiplicities.entrySet().stream().sorted(
                Comparator.<Map.Entry<PokerCard.Value, Integer>, Integer>comparing(Map.Entry::getValue)
                        .thenComparing(Map.Entry::getKey));

    }

    public static OnePair of(PokerHand hand) {
        return new OnePair(hand);
    }

    @Override
    int getPrimaryValue() {
        return 1;
    }
}
