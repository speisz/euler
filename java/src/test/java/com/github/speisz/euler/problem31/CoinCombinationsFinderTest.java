package com.github.speisz.euler.problem31;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.speisz.euler.problem31.CoinCombinationsFinder.CoinCombination.coinCombination;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class CoinCombinationsFinderTest {
    @Test
    void findsCoinCombinationsForValue() {
        List<CoinCombinationsFinder.CoinCombination> combinations = new CoinCombinationsFinder(5, 2, 1).findAllFor(10);
        assertThat(combinations, contains(
                coinCombination(5, 5),
                coinCombination(5, 2, 2, 1),
                coinCombination(5, 2, 1, 1, 1),
                coinCombination(5, 1, 1, 1, 1, 1),
                coinCombination(2, 2, 2, 2, 2),
                coinCombination(2, 2, 2, 2, 1, 1),
                coinCombination(2, 2, 2, 1, 1, 1, 1),
                coinCombination(2, 2, 1, 1, 1, 1, 1, 1),
                coinCombination(2, 1, 1, 1, 1, 1, 1, 1, 1),
                coinCombination(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)));
    }
}
