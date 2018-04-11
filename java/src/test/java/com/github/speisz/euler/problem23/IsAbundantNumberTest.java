package com.github.speisz.euler.problem23;

import org.junit.Test;

import static com.github.speisz.euler.problem23.IsAbundantNumber.isAbundantNumber;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class IsAbundantNumberTest {
    @Test
    public void checksIfNumberIsAbundant() {
        assertThat(isAbundantNumber().test(12), is(true));
    }

    @Test
    public void checksIfNumberIsNotAbundant() {
        assertThat(isAbundantNumber().test(28), is(false));
    }
}
