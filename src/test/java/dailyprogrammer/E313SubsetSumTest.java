package dailyprogrammer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class E313SubsetSumTest {
    
    @Test
    public void testBasic1() {
        int[] input = new int[] {1, 2, 3};
        assertFalse(E313SubsetSum.subsetSumToZeroBasic(input));
    }


    @Test
    public void testBasic2() {
        int[] input = new int[] {-5, -3, -1, 2, 4, 6};
        assertFalse(E313SubsetSum.subsetSumToZeroBasic(input));
    }


    @Test
    public void testBasic3() {
        int[] input = new int[0];
        assertFalse(E313SubsetSum.subsetSumToZeroBasic(input));
    }


    @Test
    public void testBasic4() {
        int[] input = new int[] {-1, 1};
        assertTrue(E313SubsetSum.subsetSumToZeroBasic(input));
    }


    @Test
    public void testBasic5() {
        int[] input = new int[] {-97364, -71561, -69336, 19675, 71561, 97863};
        assertTrue(E313SubsetSum.subsetSumToZeroBasic(input));
    }


    @Test
    public void testBasic6() {
        int[] input = new int[] {-53974, -39140, -36561, -23935, -15680, 0};
        assertTrue(E313SubsetSum.subsetSumToZeroBasic(input));
    }
}