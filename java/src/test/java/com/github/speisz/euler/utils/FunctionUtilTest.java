package com.github.speisz.euler.utils;

import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class FunctionUtilTest {

    @Test
    void appliesOperatorNTimes() {
        UnaryOperator<Integer> operator = mock(UnaryOperator.class);
        when(operator.apply(0)).thenReturn(1);
        when(operator.apply(1)).thenReturn(3);
        when(operator.apply(3)).thenReturn(6);

        Integer result = FunctionUtil.apply(0, operator, 3);

        assertThat(result, is(6));
        verify(operator, times(3)).apply(any());
    }
}
