package com.github.speisz.euler.problem31;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

import static com.github.speisz.euler.problem31.CoinCombinationsFinder.CoinCombination.coinCombination;
import static com.github.speisz.euler.utils.ListUtil.copy;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.Arrays.asList;

class CoinCombinationsFinder {
    private Integer[] coinValues;

    CoinCombinationsFinder(Integer... coinValues) {
        this.coinValues = coinValues;
    }

    List<CoinCombination> findAllFor(int value) {
        return findAllFor(value, asList(coinValues), coinCombination());
    }

    private List<CoinCombination> findAllFor(int value, List<Integer> coinValues, CoinCombination coinCombination) {
        if (value == 0) {
            return newArrayList(coinCombination);
        }
        if (value <= 0 || coinValues.isEmpty()) {
            return newArrayList();
        }
        Integer currentValue = coinValues.get(0);
        List<CoinCombination> combinations = findAllFor(value - currentValue, coinValues, coinCombination.copyAndAdd(currentValue));
        combinations.addAll(findAllFor(value, copy(coinValues, values -> values.remove(currentValue)), coinCombination));
        return combinations;
    }

    static class CoinCombination {

        private List<Integer> combination;

        private CoinCombination(Integer... combination) {
            this.combination = newArrayList(combination);
        }

        private CoinCombination(CoinCombination coinCombination) {
            this.combination = newArrayList(coinCombination.combination);
        }

        static CoinCombination coinCombination(Integer... combination) {
            return new CoinCombination(combination);
        }

        CoinCombination copyAndAdd(Integer value) {
            CoinCombination newCoinCombination = new CoinCombination(this);
            newCoinCombination.add(value);
            return newCoinCombination;
        }

        private void add(Integer value) {
            combination.add(value);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                    .append("combination", combination)
                    .toString();
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }

            if (other == null || getClass() != other.getClass()) {
                return false;
            }

            CoinCombination otherCoinCombination = (CoinCombination) other;

            return new EqualsBuilder()
                    .append(combination, otherCoinCombination.combination)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder()
                    .append(combination)
                    .toHashCode();
        }
    }
}
