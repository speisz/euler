package problem4;

import org.junit.Test;
import utils.Tuple;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static problem4.CartesianProduct.computeFor;
import static problem4.CartesianProduct.computeForStreams;

public class CartesianProductTest {

    @Test
    public void buildsCartesianForTwoOneElementCollections() {
        List<Tuple<String>> product = computeFor(singletonList("a"), singletonList("b"));
        assertThat(product, hasSize(1));
        assertThat(product, hasItem(Tuple.of("a", "b")));
    }

    @Test
    public void buildsCartesianForTwoArbitraryCollections() {
        List<Tuple<String>> product = computeFor(asList("a", "b"), asList("a", "d", "e"));
        assertThat(product, hasSize(6));
        assertThat(product, hasItems(
                Tuple.of("a", "a"),
                Tuple.of("a", "d"),
                Tuple.of("a", "e"),
                Tuple.of("b", "a"),
                Tuple.of("b", "d"),
                Tuple.of("b", "e")
        ));
    }

    @Test
    public void buildsCartesianStreamForTwoArbitraryStreams() {
        List<Tuple<String>> product = computeForStreams(() -> Stream.of("a", "b"), () -> Stream.of("a", "d", "e")).collect(toList());
        assertThat(product, hasSize(6));
        assertThat(product, hasItems(
                Tuple.of("a", "a"),
                Tuple.of("a", "d"),
                Tuple.of("a", "e"),
                Tuple.of("b", "a"),
                Tuple.of("b", "d"),
                Tuple.of("b", "e")
        ));
    }
}
