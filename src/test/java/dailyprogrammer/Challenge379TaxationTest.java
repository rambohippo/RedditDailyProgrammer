package dailyprogrammer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Challenge379TaxationTest {

    @Test
    public void testTax0() {
        assertEquals(0, Challenge379Taxation.tax(0));
    }


    @Test
    public void testTaxFirst() {
        assertEquals(0, Challenge379Taxation.tax(10000));
    }


    @Test
    public void testTaxSecondLow() {
        assertEquals(0, Challenge379Taxation.tax(10009));
    }


    @Test
    public void testTaxSecondLow2() {
        assertEquals(1, Challenge379Taxation.tax(10010));
    }


    @Test
    public void testTaxSecond() {
        assertEquals(200, Challenge379Taxation.tax(12000));
    }


    @Test
    public void testTaxThird() {
        assertEquals(8697, Challenge379Taxation.tax(56789));
    }


    @Test
    public void testTaxHigh() {
        assertEquals(473326, Challenge379Taxation.tax(1234567));
    }


    @Test
    public void testOverall0() {
        assertEquals(0, Challenge379Taxation.overall(0));
    }


    @Test
    public void testOverallLow() {
        assertEquals(25000, Challenge379Taxation.overall(0.06f));
    }


    @Test
    public void testOverallMid() {
        assertEquals(34375, Challenge379Taxation.overall(0.09f));
    }


    @Test
    public void testOverallHigh() {
        assertEquals(256250, Challenge379Taxation.overall(0.32f));
    }


    @Test
    public void testOverallImpossible() {
        assertEquals(-1, Challenge379Taxation.overall(0.40f));
    }
}