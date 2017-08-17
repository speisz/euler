package problem4;

import java.util.function.Predicate;

public class IntegerPalindromeCheck implements Predicate<Integer> {

    private StringPalindromeCheck stringPalindromeCheck = new StringPalindromeCheck();

    @Override
    public boolean test(Integer number) {
        return stringPalindromeCheck.test(String.valueOf(number));
    }
}
