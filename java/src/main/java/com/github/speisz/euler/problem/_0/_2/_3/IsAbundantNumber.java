package com.github.speisz.euler.problem._0._2._3;

import com.github.speisz.euler.problem._0._2._1.ProperDivisors;

import java.util.function.IntPredicate;

public class IsAbundantNumber implements IntPredicate {

    private IsAbundantNumber() {
    }

    static IsAbundantNumber isAbundantNumber() {
        return new IsAbundantNumber();
    }

    @Override
    public boolean test(int n) {
        return n < ProperDivisors.stream(n).mapToInt(m -> m).sum();
    }
}
