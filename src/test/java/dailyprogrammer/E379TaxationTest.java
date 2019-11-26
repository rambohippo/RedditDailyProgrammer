package dailyprogrammer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class E379TaxationTest {

    @Test
    public void testTax0() {
        assertEquals(0, E379Taxation.tax(0));
    }


    @Test
    public void testTaxFirst() {
        assertEquals(0, E379Taxation.tax(10000));
    }


    @Test
    public void testTaxSecondLow() {
        assertEquals(0, E379Taxation.tax(10009));
    }


    @Test
    public void testTaxSecondLow2() {
        assertEquals(1, E379Taxation.tax(10010));
    }


    @Test
    public void testTaxSecond() {
        assertEquals(200, E379Taxation.tax(12000));
    }


    @Test
    public void testTaxThird() {
        assertEquals(8697, E379Taxation.tax(56789));
    }


    @Test
    public void testTaxHigh() {
        assertEquals(473326, E379Taxation.tax(1234567));
    }
}