package com.github.speisz.euler.problem22;

import com.github.speisz.euler.utils.WordValueCalculator;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static java.math.BigInteger.ZERO;

public class NameScoreCalculator {
    private WordValueCalculator wordValueCalculator;

    private NameScoreCalculator(WordValueCalculator wordValueCalculator) {
        this.wordValueCalculator = wordValueCalculator;
    }

    static NameScoreCalculator create(WordValueCalculator wordValueCalculator) {
        return new NameScoreCalculator(wordValueCalculator);
    }

    public BigInteger calculate(List<String> names) {
        AtomicLong positionScore = new AtomicLong(1);
        return names.stream()
                .sorted()
                .map(wordValueCalculator::calculateFor)
                .map(value -> positionScore.getAndIncrement() * value)
                .map(BigInteger::valueOf)
                .reduce(ZERO, BigInteger::add);
    }
}
