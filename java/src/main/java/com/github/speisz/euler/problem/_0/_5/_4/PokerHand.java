package com.github.speisz.euler.problem._0._5._4;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PokerHand {
    private List<PokerCard> cards;

    private PokerHand(String hand) {
        this(parse(hand));
    }

    private PokerHand(List<PokerCard> cards) {
        this.cards = cards;
    }

    public static PokerHand of(String hand) {
        return new PokerHand(hand);
    }

    public static PokerHand of(List<PokerCard> cards) {
        return new PokerHand(cards);
    }

    private static List<PokerCard> parse(String hand) {
        return Stream.of(hand.split(" "))
                .map(card -> PokerCard.of(PokerCard.Value.of(card.substring(0, 1)), PokerCard.Color.valueOf(card.substring(1))))
                .collect(toList());
    }

    public Stream<PokerCard> stream() {
        return cards.stream();
    }
}
