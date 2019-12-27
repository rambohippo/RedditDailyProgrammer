package dailyprogrammer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class E375IncrementDigitsTest {

    @Test
    public void testZero() {
        assertEquals(1, E375IncrementDigits.incrementDigits(0));
    }


    @Test
    public void testOne() {
        assertEquals(2, E375IncrementDigits.incrementDigits(1));
    }


    @Test
    public void testMiddle() {
        assertEquals(211098, E375IncrementDigits.incrementDigits(10987));
    }


    @Test
    public void testLarge() {
        assertEquals(234567891021l, E375IncrementDigits.incrementDigits(12345678910l));
    }


    @Test
    public void testNines() {
        assertEquals(1010101010, E375IncrementDigits.incrementDigits(99999));
    }


    @Test
    public void testNegativeOne() {
        assertEquals(0, E375IncrementDigits.incrementDigits(-1));
    }


    @Test
    public void testNegativeOnes() {
        assertEquals(0, E375IncrementDigits.incrementDigits(-111111));
    }


    @Test
    public void testNegativeOnesShort() {
        assertEquals(-11, E375IncrementDigits.incrementDigits(-100));
    }


    @Test
    public void testNegativeShort() {
        assertEquals(-234, E375IncrementDigits.incrementDigits(-345));
    }


    @Test
    public void testNegativeMiddle() {
        assertEquals(-1876, E375IncrementDigits.incrementDigits(-10987));
    }


    @Test
    public void testNegativeLarge() {
        assertEquals(-1234567801l, E375IncrementDigits.incrementDigits(-12345678910l));
    }
}