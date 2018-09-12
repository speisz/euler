package com.github.speisz.euler.problem._0._1._7;

import java.util.Optional;
import java.util.stream.Stream;

import static com.github.speisz.euler.utils.MathUtil.pow;
import static com.github.speisz.euler.utils.OptionalUtil.firstNonEmpty;

public class WordOfNumber {
    public static String get(int n) {
        Optional<String> tensAndOnes = tensAndOnes(n);
        return thousandsAndHundreds(n)
                .map(hundreds -> tensAndOnes
                        .map(innerTensAndOnes -> hundreds + "and" + innerTensAndOnes)
                        .orElse(hundreds))
                .orElse(tensAndOnes.orElse(""));
    }

    private static Optional<String> thousandsAndHundreds(int n) {
        return firstNonEmpty(thousands(n).map(t -> hundreds(n).map(h -> t + h).orElse(t)), hundreds(n));
    }

    private static Optional<String> thousands(int n) {
        return word(getDigit(n, 4), "thousand");
    }

    private static Optional<String> tensAndOnes(int n) {
        Optional<String> ones = ones(n);
        return firstNonEmpty(ExceptionalCases.getWordFor(n % 100), firstNonEmpty(tens(n).map(s -> s + ones.orElse("")), ones));
    }

    private static Optional<String> ones(int n) {
        return word(getDigit(n, 1), "");
    }

    private static int getDigit(int n, int position) {
        return n % (int) pow(10, position) / (int) pow(10, position - 1);
    }

    private static Optional<String> word(int n, String appendix) {
        return Ones.of(n).map(Enum::name).map(name -> name + appendix);
    }

    private static Optional<String> tens(int n) {
        int tens = getDigit(n, 2);
        return firstNonEmpty(TensExceptionalCases.getWordFor(tens), word(tens, "ty"));
    }

    private static Optional<String> hundreds(int n) {
        return word(getDigit(n, 3), "hundred");
    }

    enum Ones {
        one(1),
        two(2),
        three(3),
        four(4),
        five(5),
        six(6),
        seven(7),
        eight(8),
        nine(9);

        private int numericalValue;

        Ones(int numericalValue) {
            this.numericalValue = numericalValue;
        }

        static Optional<Ones> of(int numericalValue) {
            return Stream.of(values())
                    .filter(digitWord -> numericalValue == digitWord.numericalValue)
                    .findFirst();
        }
    }

    enum TensExceptionalCases {
        ten(1),
        twenty(2),
        thirty(3),
        forty(4),
        fifty(5),
        eighty(8);

        private int numericalValue;

        TensExceptionalCases(int numericalValue) {
            this.numericalValue = numericalValue;
        }

        static Optional<String> getWordFor(int numericalValue) {
            return Stream.of(values())
                    .filter(exceptionalCase -> numericalValue == exceptionalCase.numericalValue)
                    .findFirst()
                    .map(Enum::name);
        }
    }

    enum ExceptionalCases {
        eleven(11),
        twelve(12),
        thirteen(13),
        fourteen(14),
        fifteen(15),
        sixteen(16),
        seventeen(17),
        eighteen(18),
        nineteen(19);

        private int numericalValue;

        ExceptionalCases(int numericalValue) {
            this.numericalValue = numericalValue;
        }

        static Optional<String> getWordFor(int numericalValue) {
            return Stream.of(values())
                    .filter(exceptionalCase -> numericalValue == exceptionalCase.numericalValue)
                    .findFirst()
                    .map(Enum::name);
        }
    }
}
