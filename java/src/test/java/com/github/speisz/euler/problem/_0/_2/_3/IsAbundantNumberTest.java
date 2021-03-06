package com.github.speisz.euler.problem._0._2._3;

import org.junit.jupiter.api.Test;

import static com.github.speisz.euler.problem._0._2._3.IsAbundantNumber.isAbundantNumber;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class IsAbundantNumberTest {
    @Test
    void checksIfNumberIsAbundant() {
        assertThat(isAbundantNumber().test(12), is(true));
    }

    @Test
    void checksIfNumberIsNotAbundant() {
        assertThat(isAbundantNumber().test(28), is(false));
    }
}
