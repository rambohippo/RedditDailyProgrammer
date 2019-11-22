package dailyprogrammer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Challenge381YahtzeeTest {
    
    @Test
    public void testBasic() {
        assertEquals(10, Challenge381Yahtzee.yahtzee_upper(new int[] {2, 3, 5, 5, 6}));
    }

    @Test
    public void testIntegerCompare() {
        assertEquals(4, Challenge381Yahtzee.yahtzee_upper_integer_compare(new int[] {1, 1, 1, 1, 3}));
    }

    @Test
    public void testStream() {
        assertEquals(6, Challenge381Yahtzee.yahtzee_upper_stream(new int[] {1, 1, 1, 3, 3}));
    }

    @Test
    public void testComparator() {
        assertEquals(5, Challenge381Yahtzee.yahtzee_upper_comparator(new int[] {1, 2, 3, 4, 5}));
    }

    @Test
    public void testComparingInt() {
        assertEquals(30, Challenge381Yahtzee.yahtzee_upper_comparing_int(new int[] {6, 6, 6, 6, 6}));
    }

    @Test
    public void testLargeNumbers() {
        int[] testArray = new int[] { 1654, 1654, 50995, 30864, 1654, 50995, 22747, 1654, 1654, 1654,
            1654, 1654, 30864, 4868, 1654, 4868, 1654, 30864, 4868, 30864 };
        assertEquals(123456, Challenge381Yahtzee.yahtzee_upper_integer_compare(testArray));
        assertEquals(123456, Challenge381Yahtzee.yahtzee_upper_stream(testArray));
        assertEquals(123456, Challenge381Yahtzee.yahtzee_upper_comparator(testArray));
        assertEquals(123456, Challenge381Yahtzee.yahtzee_upper_comparing_int(testArray));
    }
}