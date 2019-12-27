package dailyprogrammer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class E377AxisAlignedPackingTest {

    @Test
    public void testFit1_1() {
        assertEquals(12, E377AxisAlignedPacking.fit1(25, 18, 6, 5));
    }

    @Test
    public void testFit1_2() {
        assertEquals(100, E377AxisAlignedPacking.fit1(10, 10, 1, 1));
    }

    @Test
    public void testFit1_3() {
        assertEquals(10, E377AxisAlignedPacking.fit1(12, 34, 5, 6));
    }

    @Test
    public void testFit1_4() {
        assertEquals(5676, E377AxisAlignedPacking.fit1(12345, 678910, 1112, 1314));
    }

    @Test
    public void testFit1_5() {
        assertEquals(0, E377AxisAlignedPacking.fit1(5, 100, 6, 1));
    }
}