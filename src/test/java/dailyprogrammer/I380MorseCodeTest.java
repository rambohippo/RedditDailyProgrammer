package dailyprogrammer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class I380MorseCodeTest {

    // @Test
    // public void testAlphabet1() {
    //     assertTrue(I380MorseCode.smalpha(
    //         ".--...-.-.-.....-.--........----.-.-..---.---.--.--.-.-....-..-...-.---..--.----..")
    //         .contains("wirnbfzehatqlojpgcvusyxkmd"));
    // }


    // @Test
    // public void testAlphabet2() {
    //     assertTrue(I380MorseCode.smalpha(
    //         ".----...---.-....--.-........-----....--.-..-.-..--.--...--..-.---.--..-.-...--..-")
    //         .contains("wzjlepdsvothqfxkbgrmyicuna"));
    // }


    // @Test
    // public void testAlphabet3() {
    //     assertTrue(I380MorseCode.smalpha(
    //         "..-...-..-....--.---.---.---..-..--....-.....-..-.--.-.-.--.-..--.--..--.----..-..")
    //         .contains("uvfsqmjazxthbidyrkcwegponl"));
    // }


    @Test
    public void testAlphabet4() {
        List<String> result = I380MorseCode.smalpha(
            "......-..--...---.-....---...--....--.-..---.....---.-.---..---.-....--.-.---.-.--");
        assertTrue(result.contains("sefaboluzpvcwdijrmxqhgynkt"));
        assertTrue(result.size() == 41);
    }


    @Test
    public void testFindFirst1() {
        String result = I380MorseCode.smalphaFirstResult(
            ".--...-.-.-.....-.--........----.-.-..---.---.--.--.-.-....-..-...-.---..--.----..");
        assertNotEquals("", result);
        assertEquals("pfchysivorxqgmwenbldajuktz", result);
    }


    @Test
    public void testFindFirst2() {
        String result = I380MorseCode.smalphaFirstResult(
            ".----...---.-....--.-........-----....--.-..-.-..--.--...--..-.---.--..-.-...--..-");
        assertNotEquals("", result);
        assertEquals("jboluchvmziqfxysgawknrdpet", result);
    }


    @Test
    public void testFindFirst3() {
        String result = I380MorseCode.smalphaFirstResult(
            "..-...-..-....--.---.---.---..-..--....-.....-..-.--.-.-.--.-..--.--..--.----..-..");
        assertNotEquals("", result);
        assertEquals("uvfsqgojixbrhdyaekcpzmwtnl", result);
    }


    @Test
    public void testFindFirst4() {
        String result = I380MorseCode.smalphaFirstResult(
            "......-..--...---.-....---...--....--.-..---.....---.-.---..---.-....--.-.---.-.--");
        assertNotEquals("", result);
        assertEquals("hfaboluzpvcwdijrmxqsegynkt", result);
    }


    @Test
    public void testBonus1() {
        long time = I380MorseCode.smalphaBonus1();
        double seconds = time / 1000.0;
        System.out.printf("Total Time: %.3f seconds", seconds);
        assertTrue(seconds < 45.0);
    }
}