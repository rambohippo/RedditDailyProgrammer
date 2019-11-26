package dailyprogrammer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class E372BalancedTest {

    @Test
    public void testAffirm() {
        assertTrue(E372Balanced.balanced("xxxyyy"));
    }


    @Test
    public void testAffirmReverse() {
        assertTrue(E372Balanced.balanced("yyyxxx"));
    }


    @Test
    public void testReject() {
        assertFalse(E372Balanced.balanced("xxxyyyy"));
    }


    @Test
    public void testAffirmLong() {
        assertTrue(E372Balanced.balanced("yyxyxxyxxyyyyxxxyxyx"));
    }


    @Test
    public void testRejectLong() {
        assertFalse(E372Balanced.balanced("xyxxxxyyyxyxxyxxyy"));
    }


    @Test
    public void testEmpty() {
        assertTrue(E372Balanced.balanced(""));
    }


    @Test
    public void testSingle() {
        assertFalse(E372Balanced.balanced("x"));
    }


    @Test
    public void testBonusSingle() {
        assertTrue(E372Balanced.balanced_bonus("x"));
    }


    @Test
    public void testBonusEmpty() {
        assertTrue(E372Balanced.balanced_bonus(""));
    }


    @Test
    public void testBonusShort() {
        assertTrue(E372Balanced.balanced_bonus("www"));
    }


    @Test
    public void testBonusShortReject() {
        assertFalse(E372Balanced.balanced_bonus("pqq"));
    }


    @Test
    public void testBonusLong() {
        assertTrue(E372Balanced.balanced_bonus("abcdefghijklmnopqrstuvwxyz"));
    }


    @Test
    public void testBonusLongReject() {
        assertFalse(E372Balanced.balanced_bonus("fdedfdeffeddefeeeefddf"));
    }


    @Test
    public void testBonusBasic1() {
        assertTrue(E372Balanced.balanced_bonus("xxxyyyzzz"));
    }


    @Test
    public void testBonusBasic2() {
        assertTrue(E372Balanced.balanced_bonus("abccbaabccba"));
    }


    @Test
    public void testBonusBasic3() {
        assertFalse(E372Balanced.balanced_bonus("xxxyyyzzzz"));
    }
}