package com.github.speisz.euler.problem._0._0._9;

import com.github.speisz.euler.utils.MathUtil;
import com.github.speisz.euler.utils.TripleUtil;
import org.apache.commons.lang3.tuple.Triple;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.github.speisz.euler.utils.StreamUtil.descendingPairStream;
import static com.github.speisz.euler.utils.StreamUtil.descendingTripleStream;
import static java.util.stream.IntStream.iterate;

public class PythagoreanTripleStream implements Supplier<Stream<Triple<Integer, Integer, Integer>>> {

    @Override
    public Stream<Triple<Integer, Integer, Integer>> get() {
        return descendingTripleStream(descendingPairStream(iterate(5, operand -> operand + 1)))
                .map(TripleUtil::swapLeftAndRight)
                .filter(MathUtil::isPythagorean);
    }
}
