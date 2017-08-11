package testutils;

import static org.junit.Assert.fail;

public class Assertions {
    public static <E extends Exception> void assertExceptionIsThrown(Runnable runnable, Class<E> expectedExceptionClass) {
        try {
            runnable.run();
            fail("Expected test to throw " + expectedExceptionClass);
        } catch (Exception actualException) {
            if (!expectedExceptionClass.isAssignableFrom(actualException.getClass())) {
                throw actualException;
            }
        }
    }
}
