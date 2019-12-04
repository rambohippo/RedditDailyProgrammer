package dailyprogrammer;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;

public class I317CountingElementsTest {

    @Test
    public void testBasic() {
        I317CountingElements count = new I317CountingElements();
        String testInput = "C6H12O6";
        Map<String, Integer> expected = new HashMap<>();
        expected.put("C", 6);
        expected.put("H", 12);
        expected.put("O", 6);

        assertEquals(expected, count.countElements(testInput));
    }


    @Test
    public void testFormula1() {
        I317CountingElements count = new I317CountingElements();
        String testInput = "CCl2F2";
        Map<String, Integer> expected = new HashMap<>();
        expected.put("C", 1);
        expected.put("Cl", 2);
        expected.put("F", 2);

        assertEquals(expected, count.countElements(testInput));
    }


    @Test
    public void testFormula2() {
        I317CountingElements count = new I317CountingElements();
        String testInput = "NaHCO3";
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Na", 1);
        expected.put("H", 1);
        expected.put("C", 1);
        expected.put("O", 3);

        assertEquals(expected, count.countElements(testInput));
    }


    @Test
    public void testFormula3() {
        I317CountingElements count = new I317CountingElements();
        String testInput = "C4H8(OH)2";
        Map<String, Integer> expected = new HashMap<>();
        expected.put("C", 4);
        expected.put("H", 10);
        expected.put("O", 2);

        assertEquals(expected, count.countElements(testInput));
    }


    @Test
    public void testFormula4() {
        I317CountingElements count = new I317CountingElements();
        String testInput = "PbCl(NH3)2(COOH)2";
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Pb", 1);
        expected.put("Cl", 1);
        expected.put("N", 2);
        expected.put("H", 8);
        expected.put("C", 2);
        expected.put("O", 4);

        assertEquals(expected, count.countElements(testInput));
    }
}