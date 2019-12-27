package dailyprogrammer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class E207BioinformaticsTest {

    @Test
    public void testBasic1() {
        assertEquals("T A T T C G",
            E207Bioinformatics.findSecondDNAStrand("A T A A G C").get(1));
    }


    @Test
    public void testBasic2() {
        assertEquals("T T A C G G A T A C C G",
            E207Bioinformatics.findSecondDNAStrand("A A T G C C T A T G G C").get(1));
    }


    @Test
    public void testBasic3() {
        assertEquals("T A C A A A G C T C C G A T T",
            E207Bioinformatics.findSecondDNAStrand("A T G T T T C G A G G C T A A").get(1));
    }


    @Test
    public void testBonus1() {
        assertEquals("Lle Ser",
            E207Bioinformatics.findProteinSequence("A T A A G C").get(1));
    }


    @Test
    public void testBonus2() {
        assertEquals("Asn Ala Tyr Gly",
            E207Bioinformatics.findProteinSequence("A A T G C C T A T G G C").get(1));
    }


    @Test
    public void testBonus3() {
        assertEquals("Met Phe Arg Gly STOP",
            E207Bioinformatics.findProteinSequence("A T G T T T C G A G G C T A A").get(1));
    }
}