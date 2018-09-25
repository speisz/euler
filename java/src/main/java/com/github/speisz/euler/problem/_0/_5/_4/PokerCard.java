package com.github.speisz.euler.problem._0._5._4;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.stream.Stream;

public class PokerCard {
    private Value value;
    private Color color;

    private PokerCard(Value value, Color color) {
        this.value = value;
        this.color = color;
    }

    public static PokerCard of(Value value, Color color) {
        return new PokerCard(value, color);
    }

    public Value getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        PokerCard pokerCard = (PokerCard) o;

        return new EqualsBuilder()
                .append(value, pokerCard.value)
                .append(color, pokerCard.color)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(value)
                .append(color)
                .toHashCode();
    }

    public enum Color {
        C, S, H, D;
    }

    public enum Value {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11, "J"),
        QUEEN(12, "Q"),
        KING(13, "K"),
        ACE(14, "A");

        private final int value;
        private final String symbol;

        Value(int value) {
            this(value, String.valueOf(value));
        }

        Value(int value, String symbol) {
            this.value = value;
            this.symbol = symbol;
        }

        public static Value of(String symbol) {
            return Stream.of(values())
                    .filter(value -> symbol.equals(value.symbol))
                    .findFirst().orElseThrow();
        }

        public int numericValue() {
            return value;
        }
    }
}
