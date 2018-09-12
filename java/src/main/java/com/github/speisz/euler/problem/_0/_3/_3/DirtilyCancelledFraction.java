package com.github.speisz.euler.problem._0._3._3;

import org.apache.commons.lang3.math.Fraction;

import java.util.Optional;
import java.util.function.Function;

import static com.github.speisz.euler.utils.IntUtil.containedIn;
import static com.github.speisz.euler.utils.MathUtil.digits;
import static java.lang.Integer.parseInt;
import static org.apache.commons.lang3.math.Fraction.getFraction;

public class DirtilyCancelledFraction {

    private Fraction cancelledFraction;

    public static DirtilyCancelledFraction of(Fraction fraction) {
        return new DirtilyCancelledFraction(fraction);
    }

    private DirtilyCancelledFraction(Fraction initialFraction) {
        cancelledFraction = dirtyCancellation(initialFraction);
    }

    private Fraction dirtyCancellation(Fraction fraction) {
        Optional<Integer> firstCommonDigit = findFirstCommonDigit(fraction.getNumerator(), fraction.getDenominator());
        Fraction cancelledFraction = getFraction(
                removeFirstDigitFromNumber(fraction.getNumerator(), firstCommonDigit),
                removeFirstDigitFromNumber(fraction.getDenominator(), firstCommonDigit));
        if (cancelledFraction.equals(fraction)) {
            return cancelledFraction;
        }
        return dirtyCancellation(cancelledFraction);
    }

    private Integer removeFirstDigitFromNumber(int number, @SuppressWarnings("OptionalUsedAsFieldOrParameterType") Optional<Integer> optionalDigit) {
        return optionalDigit.map(withoutFirstOccurrenceOfDigit(number)).orElse(number);
    }

    private Function<Integer, Integer> withoutFirstOccurrenceOfDigit(int number) {
        return digit -> removeFirstDigitFromNumber(digit, number);
    }

    private int removeFirstDigitFromNumber(int digit, int number) {
        return parseInt(String.valueOf(number).replaceFirst(String.valueOf(digit), ""));
    }

    private Optional<Integer> findFirstCommonDigit(int numerator, int denominator) {
        if (cannotBeDirtilyCancelled(numerator, denominator)) {
            return Optional.empty();
        }
        return digits(numerator).filter(containedIn(denominator)).boxed().findFirst();
    }

    private boolean cannotBeDirtilyCancelled(int numerator, int denominator) {
        return numerator < 10 || denominator < 10;
    }

    Fraction asFraction() {
        return cancelledFraction;
    }
}
