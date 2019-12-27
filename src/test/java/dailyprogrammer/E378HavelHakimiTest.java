package dailyprogrammer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class E378HavelHakimiTest {

    // Testing Warmup 1
    @Test
    public void testRemoveZero1() {
        assertArrayEquals(new int[] {5, 3, 2, 6, 2, 7, 2, 5},
            E378HavelHakimi.warmup1(new int[] {5, 3, 0, 2, 6, 2, 0, 7, 2, 5}));
    }

    @Test
    public void testRemoveZero2() {
        assertArrayEquals(new int[] {4, 1, 3},
            E378HavelHakimi.warmup1(new int[] {4, 0, 0, 1, 3}));
    }

    @Test
    public void testRemoveZero3() {
        assertArrayEquals(new int[] {1, 2, 3},
            E378HavelHakimi.warmup1(new int[] {1, 2, 3}));
    }

    @Test
    public void testRemoveZero4() {
        assertArrayEquals(new int[0],
            E378HavelHakimi.warmup1(new int[] {0, 0, 0}));
    }

    @Test
    public void testRemoveZero5() {
        assertArrayEquals(new int[0], E378HavelHakimi.warmup1(new int[0]));
    }


    // Testing Warmup 2
    @Test
    public void testDecendingSort1() {
        assertArrayEquals(new int[] {5, 4, 3, 2, 1},
            E378HavelHakimi.warmup2(new int[] {5, 1, 3, 4, 2}));
    }

    @Test
    public void testDecendingSort2() {
        assertArrayEquals(new int[] {4, 0, 0, 0, 0},
            E378HavelHakimi.warmup2(new int[] {0, 0, 0, 4, 0}));
    }

    @Test
    public void testDecendingSort3() {
        assertArrayEquals(new int[] {1},
            E378HavelHakimi.warmup2(new int[] {1}));
    }

    @Test
    public void testDecendingSort4() {
        assertArrayEquals(new int[0], E378HavelHakimi.warmup2(new int[0]));
    }


    // Testing Warmup 3
    @Test
    public void testLengthCheck1() {
        assertFalse(E378HavelHakimi.warmup3(7, new int[] {6, 5, 5, 3, 2, 2, 2}));
    }

    @Test
    public void testLengthCheck2() {
        assertFalse(E378HavelHakimi.warmup3(5, new int[] {5, 5, 5, 5, 5}));
    }

    @Test
    public void testLengthCheck3() {
        assertTrue(E378HavelHakimi.warmup3(5, new int[] {5, 5, 5, 5}));
    }

    @Test
    public void testLengthCheck4() {
        assertTrue(E378HavelHakimi.warmup3(3, new int[] {1, 1}));
    }

    @Test
    public void testLengthCheck5() {
        assertTrue(E378HavelHakimi.warmup3(1, new int[0]));
    }

    @Test
    public void testLengthCheck6() {
        assertFalse(E378HavelHakimi.warmup3(0, new int[0]));
    }


    // Testing Warmup 4
    @Test
    public void testFrontElimination1() {
        assertArrayEquals(new int[] {4, 3, 2, 1, 1},
            E378HavelHakimi.warmup4(4, new int[] {5, 4, 3, 2, 1}));
    }

    @Test
    public void testFrontElimination2() {
        assertArrayEquals(new int[] {13, 12, 12, 12, 11, 9, 7, 7, 6, 6, 5, 6, 4, 4, 2},
            E378HavelHakimi.warmup4(11,
            new int[] {14, 13, 13, 13, 12, 10, 8, 8, 7, 7, 6, 6, 4, 4, 2}));
    }

    @Test
    public void testFrontElimination3() {
        assertArrayEquals(new int[] {9, 10, 10},
            E378HavelHakimi.warmup4(1, new int[] {10, 10, 10}));
    }

    @Test
    public void testFrontElimination4() {
        assertArrayEquals(new int[] {9, 9, 9},
            E378HavelHakimi.warmup4(3, new int[] {10, 10, 10}));
    }

    @Test
    public void testFrontElimination5() {
        assertArrayEquals(new int[] {0},
            E378HavelHakimi.warmup4(1, new int[] {1}));
    }

    @Test
    public void testFrontElimination6() {
        assertArrayEquals(new int[] {1},
            E378HavelHakimi.warmup4(0, new int[] {1}));
    }


    // Testing the full Havel Hakimi algorithm
    @Test
    public void testAlgorithm1() {
        assertFalse(E378HavelHakimi.havelHakimi(new int[] {5, 3, 0, 2, 6, 2, 0, 7, 2, 5}));
    }

    @Test
    public void testAlgorithm2() {
        assertFalse(E378HavelHakimi.havelHakimi(new int[] {4, 2, 0, 1, 5, 0}));
    }

    @Test
    public void testAlgorithm3() {
        assertTrue(E378HavelHakimi.havelHakimi(new int[] {3, 1, 2, 3, 1, 0}));
    }

    @Test
    public void testAlgorithm4() {
        assertTrue(E378HavelHakimi.havelHakimi(
            new int[] {16, 9, 9, 15, 9, 7, 9, 11, 17, 11, 4, 9, 12, 14, 14, 12, 17, 0, 3, 16}));
    }

    @Test
    public void testAlgorithm5() {
        assertTrue(E378HavelHakimi.havelHakimi(
            new int[] {14, 10, 17, 13, 4, 8, 6, 7, 13, 13, 17, 18, 8, 17, 2, 14, 6, 4, 7, 12}));
    }

    @Test
    public void testAlgorithm6() {
        assertFalse(E378HavelHakimi.havelHakimi(
            new int[] {15, 18, 6, 13, 12, 4, 4, 14, 1, 6, 18, 2, 6, 16, 0, 9, 10, 7, 12, 3}));
    }

    @Test
    public void testAlgorithm7() {
        assertFalse(E378HavelHakimi.havelHakimi(
            new int[] {6, 0, 10, 10, 10, 5, 8, 3, 0, 14, 16, 2, 13, 1, 2, 13, 6, 15, 5, 1}));
    }

    @Test
    public void testAlgorithm8() {
        assertFalse(E378HavelHakimi.havelHakimi(new int[] {2, 2, 0}));
    }

    @Test
    public void testAlgorithm9() {
        assertFalse(E378HavelHakimi.havelHakimi(new int[] {3, 2, 1}));
    }

    @Test
    public void testAlgorithm10() {
        assertTrue(E378HavelHakimi.havelHakimi(new int[] {1, 1}));
    }

    @Test
    public void testAlgorithm11() {
        assertFalse(E378HavelHakimi.havelHakimi(new int[] {1}));
    }

    @Test
    public void testAlgorithm12() {
        assertTrue(E378HavelHakimi.havelHakimi(new int[0]));
    }
}