package dailyprogrammer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Challenge381YahtzeeTest {
    
    @Test
    public void test1() {
        assertEquals(10, Challenge381Yahtzee.yahtzee_upper(new int[] {2, 3, 5, 5, 6}));
    }

    @Test
    public void test2() {
        assertEquals(4, Challenge381Yahtzee.yahtzee_upper(new int[] {1, 1, 1, 1, 3}));
    }

    @Test
    public void test3() {
        assertEquals(6, Challenge381Yahtzee.yahtzee_upper(new int[] {1, 1, 1, 3, 3}));
    }

    @Test
    public void test4() {
        assertEquals(5, Challenge381Yahtzee.yahtzee_upper(new int[] {1, 2, 3, 4, 5}));
    }

    @Test
    public void test5() {
        assertEquals(30, Challenge381Yahtzee.yahtzee_upper(new int[] {6, 6, 6, 6, 6}));
    }

    @Test
    public void testLargeNumbers() {
        assertEquals(123456, Challenge381Yahtzee.yahtzee_upper(new int[] {1654,
            1654, 50995, 30864, 1654, 50995, 22747, 1654, 1654, 1654, 1654,
            1654, 30864, 4868, 1654, 4868, 1654, 30864, 4868, 30864}));
    }
}