import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;

class RecursiveSumOfDigitsTest {

    @Test
    void testLargeNumbers() {
        // Another example with large digits
        BigInteger largeNumber = new BigInteger("12345679");
        assertEquals(37, RecursiveSumOfDigits.sumOfDigits(largeNumber));  // Corrected expected sum of digits

        // An even larger number with maximum digit '9'
        largeNumber = new BigInteger("999999999");
        assertEquals(81, RecursiveSumOfDigits.sumOfDigits(largeNumber));  // Corrected expected sum of digits
    }

    @Test
    void testSmallNumbers() {
        assertEquals(6, RecursiveSumOfDigits.sumOfDigits(new BigInteger("123")));
        assertEquals(15, RecursiveSumOfDigits.sumOfDigits(new BigInteger("12345")));
    }

    @Test
    void testZero() {
        assertEquals(0, RecursiveSumOfDigits.sumOfDigits(new BigInteger("0")));
    }

    @Test
    void testNegativeNumbers() {
        assertEquals(6, RecursiveSumOfDigits.sumOfDigits(new BigInteger("-123")));
        assertEquals(15, RecursiveSumOfDigits.sumOfDigits(new BigInteger("-12345")));
    }
}
