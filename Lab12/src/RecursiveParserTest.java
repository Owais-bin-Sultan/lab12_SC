import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RecursiveParserTest {

    @Test
    void testBasicArithmetic() {
        assertEquals(13, RecursiveParser.evaluateExpression("3 + 5 * 2"));
        assertEquals(9, RecursiveParser.evaluateExpression("10 - 2 / 2"));
    }

    @Test
    void testParenthesesHandling() {
        assertEquals(16, RecursiveParser.evaluateExpression("(3 + 5) * 2"));
        assertEquals(7, RecursiveParser.evaluateExpression("3 + (2 * (5 - 3))"));
    }

    @Test
    void testFloatingPointNumbers() {
        assertEquals(6.0, RecursiveParser.evaluateExpression("3.5 + 2.5"));
        assertEquals(7.0, RecursiveParser.evaluateExpression("3.5 * 2"));
    }

    @Test
    void testEdgeCases() {
        assertThrows(IllegalArgumentException.class, () -> RecursiveParser.evaluateExpression(""));
        assertThrows(IllegalArgumentException.class, () -> RecursiveParser.evaluateExpression("3 + 5 @ 2"));
        assertThrows(ArithmeticException.class, () -> RecursiveParser.evaluateExpression("10 / 0"));
    }
}
