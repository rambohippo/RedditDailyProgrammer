package dailyprogrammer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class E380MorseCodeTest {

    @Test
    public void testEncode1() {
        assertEquals("...---...", E380MorseCode.smorse("sos"));
    }


    @Test
    public void testEncode2() {
        assertEquals("-...-...-..-.--", E380MorseCode.smorse("daily"));
    }


    @Test
    public void testEncode3() {
        assertEquals(".--..-.-----..-..-----..-.",
            E380MorseCode.smorse("programmer"));
    }


    @Test
    public void testEncode4() {
        assertEquals("-.....-...", E380MorseCode.smorse("bits"));
    }


    @Test
    public void testEncode5() {
        assertEquals("-.....-...", E380MorseCode.smorse("three"));
    }
}