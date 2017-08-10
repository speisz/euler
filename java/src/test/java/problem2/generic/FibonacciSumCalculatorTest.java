package problem2.generic;

import org.junit.Before;
import org.junit.Test;
import utils.MathUtils;

import static java.math.BigInteger.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FibonacciSumCalculatorTest {

    private FibonacciSumCalculator fibonacciSumCalculator;
    private FibonacciSumCalculator evenFibonacciSumCalculator;

    @Before
    public void setUp() throws Exception {
        fibonacciSumCalculator = new FibonacciSumCalculator();
        evenFibonacciSumCalculator = new FibonacciSumCalculator(MathUtils::isEven);
    }

    @Test
    public void sumsFibonacciNumbersUpToBoundary() {
        assertThat(fibonacciSumCalculator.sum(1), is(valueOf(1)));
        assertThat(fibonacciSumCalculator.sum(2), is(valueOf(1 + 2)));
        assertThat(fibonacciSumCalculator.sum(3), is(valueOf(1 + 2 + 3)));
        assertThat(fibonacciSumCalculator.sum(4), is(valueOf(1 + 2 + 3)));
        assertThat(fibonacciSumCalculator.sum(5), is(valueOf(1 + 2 + 3 + 5)));
        assertThat(fibonacciSumCalculator.sum(20), is(valueOf(1 + 2 + 3 + 5 + 8 + 13)));
        assertThat(fibonacciSumCalculator.sum(50), is(valueOf(1 + 2 + 3 + 5 + 8 + 13 + 21 + 34)));
    }

    @Test
    public void sumsFibonacciNumbersUpToBoundaryWithGivenCondition() {
        assertThat(evenFibonacciSumCalculator.sum(20), is(valueOf(2 + 8)));
        assertThat(evenFibonacciSumCalculator.sum(50), is(valueOf(2 + 8 + 34)));
    }

    @Test
    public void sumsFibonacciNumbersUpToBoundaryWithGivenConditionForLargeNumbers() {
        assertThat(evenFibonacciSumCalculator.sum(Integer.MAX_VALUE), is(valueOf(1_485_607_536)));
        assertThat(evenFibonacciSumCalculator.sum(Long.MAX_VALUE), is(valueOf(3_770_056_902_373_173_214L)));
    }

    @Test
    public void sumsFibonacciNumbersUpToBoundaryWithGivenConditionForEvenLargerNumbers() {
        assertThat(evenFibonacciSumCalculator.sum(valueOf(2).pow(1000)).toString(), is("5124626790246109409208802233190843952412235260724962779588117682353682567940660271047251127033343569440125835909319019727718402174460418623984333571845544246426297972857730441069662537517947357773464679502571056902330745954251917267529361675218187268003108404052656159168719864762594440633225057958560"));
    }
}
