package dailyprogrammer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class E298ParenthesesTest {

    @Test
    public void testRemove1() {
        assertEquals("((a((bc)(de)))f)",
            E298Parentheses.removeExtraParentheses("((a((bc)(de)))f)"));
    }


    @Test
    public void testRemove2() {
        assertEquals("((zbcd)((e)fg))",
            E298Parentheses.removeExtraParentheses("(((zbcd)(((e)fg))))"));
    }


    @Test
    public void testRemove3() {
        assertEquals("ab(c)",
            E298Parentheses.removeExtraParentheses("ab((c))"));
    }


    @Test
    public void testBonus1() {
        assertEquals("",
            E298Parentheses.removeExtraParentheses("()"));
    }


    @Test
    public void testbonus2() {
        assertEquals("(fgh)",
            E298Parentheses.removeExtraParentheses("((fgh()()()))"));
    }


    @Test
    public void testBonus3() {
        assertEquals("(abc)",
            E298Parentheses.removeExtraParentheses("(abc)"));
    }


    @Test
    public void testCustom1() {
        assertEquals("ab(some(thing)x)y",
            E298Parentheses.removeExtraParentheses("ab(some(thing)x)y"));
    }
}