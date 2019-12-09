package dailyprogrammer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class I380MorseCodeTest {

    @Test
    public void testAlphabet1() {
        assertTrue(I380MorseCode.smalpha(
            ".--...-.-.-.....-.--........----.-.-..---.---.--.--.-.-....-..-...-.---..--.----..")
            .contains("wirnbfzehatqlojpgcvusyxkmd"));
    }


    @Test
    public void testAlphabet2() {
        assertTrue(I380MorseCode.smalpha(
            ".----...---.-....--.-........-----....--.-..-.-..--.--...--..-.---.--..-.-...--..-")
            .contains("wzjlepdsvothqfxkbgrmyicuna"));
    }


    @Test
    public void testAlphabet3() {
        assertTrue(I380MorseCode.smalpha(
            "..-...-..-....--.---.---.---..-..--....-.....-..-.--.-.-.--.-..--.--..--.----..-..")
            .contains("uvfsqmjazxthbidyrkcwegponl"));
    }


    @Test
    public void testAlphabet4() {
        List<String> result = I380MorseCode.smalpha(
            "......-..--...---.-....---...--....--.-..---.....---.-.---..---.-....--.-.---.-.--");
        assertTrue(result.contains("sefaboluzpvcwdijrmxqhgynkt"));
        assertTrue(result.size() == 41);
    }
}