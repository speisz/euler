package com.github.speisz.euler.utils;

public class AlphabeticalValueCalculator implements WordValueCalculator {

    public static AlphabeticalValueCalculator create() {
        return new AlphabeticalValueCalculator();
    }

    @Override
    public int calculateFor(String word) {
        return word.chars()
                .mapToObj(AlphabeticalValueCalculator::stringValueOf)
                .map(String::toUpperCase)
                .map(AlphabeticalValue::valueOf)
                .mapToInt(AlphabeticalValue::getValue)
                .sum();
    }

    private static String stringValueOf(int characterCode) {
        return String.valueOf((char) characterCode);
    }

    private AlphabeticalValueCalculator() {
    }

    @SuppressWarnings("unused")
    private enum AlphabeticalValue {
        A(1),
        B(2),
        C(3),
        D(4),
        E(5),
        F(6),
        G(7),
        H(8),
        I(9),
        J(10),
        K(11),
        L(12),
        M(13),
        N(14),
        O(15),
        P(16),
        Q(17),
        R(18),
        S(19),
        T(20),
        U(21),
        V(22),
        W(23),
        X(24),
        Y(25),
        Z(26);

        private int value;

        AlphabeticalValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
