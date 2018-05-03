package com.github.speisz.euler.math;

import org.apache.commons.lang3.tuple.Pair;

import java.util.function.Function;

public class QuadraticForm implements Function<Integer, Integer> {
    private Integer a;
    private Integer b;

    private QuadraticForm(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    private QuadraticForm(Pair<Integer, Integer> coefficients) {
        this(coefficients.getLeft(), coefficients.getRight());
    }

    public static QuadraticForm withCoefficients(Pair<Integer, Integer> coefficients) {
        return new QuadraticForm(coefficients);
    }

    public static QuadraticForm withCoefficients(Integer a, Integer b) {
        return new QuadraticForm(a, b);
    }

    @Override
    public Integer apply(Integer n) {
        return n * n + a * n + b;
    }

    public int coefficientProduct() {
        return a * b;
    }
}
