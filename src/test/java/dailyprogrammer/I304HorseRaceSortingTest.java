package dailyprogrammer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

public class I304HorseRaceSortingTest {

    @Test
    public void testGetAllSlowerHorses() {
        RaceHorse horse1 = new RaceHorse(10);
        RaceHorse horse2 = new RaceHorse(20);
        RaceHorse horse3 = new RaceHorse(30);
        RaceHorse horse4 = new RaceHorse(40);
        RaceHorse horse5 = new RaceHorse(50);
        horse1.setSlowerHorses(new HashSet<>(Arrays.asList(horse2)));
        horse2.setSlowerHorses(new HashSet<>(Arrays.asList(horse3, horse4)));
        horse4.setSlowerHorses(new HashSet<>(Arrays.asList(horse5)));

        assertTrue(horse1.getSlowerHorses().contains(horse2));
        assertTrue(horse2.getSlowerHorses().contains(horse3));
        assertFalse(horse1.getSlowerHorses().contains(horse3));
        assertFalse(horse1.getSlowerHorses().contains(horse4));
        assertFalse(horse1.getSlowerHorses().contains(horse5));

        RaceHorse.updateComparisons(Arrays.asList(horse1));
        assertTrue(horse1.getSlowerHorses().contains(horse3));
        assertTrue(horse1.getSlowerHorses().contains(horse4));
        assertTrue(horse1.getSlowerHorses().contains(horse5));
    }


    @Test
    public void testGetAllFasterHorses() {
        RaceHorse horse1 = new RaceHorse(10);
        RaceHorse horse2 = new RaceHorse(20);
        RaceHorse horse3 = new RaceHorse(30);
        RaceHorse horse4 = new RaceHorse(40);
        RaceHorse horse5 = new RaceHorse(50);
        horse1.setFasterHorses(new HashSet<>(Arrays.asList(horse2)));
        horse2.setFasterHorses(new HashSet<>(Arrays.asList(horse3, horse4)));
        horse4.setFasterHorses(new HashSet<>(Arrays.asList(horse5)));

        assertTrue(horse1.getFasterHorses().contains(horse2));
        assertTrue(horse2.getFasterHorses().contains(horse3));
        assertFalse(horse1.getFasterHorses().contains(horse3));
        assertFalse(horse1.getFasterHorses().contains(horse4));
        assertFalse(horse1.getFasterHorses().contains(horse5));

        RaceHorse.updateComparisons(Arrays.asList(horse1));
        assertTrue(horse1.getFasterHorses().contains(horse3));
        assertTrue(horse1.getFasterHorses().contains(horse4));
        assertTrue(horse1.getFasterHorses().contains(horse5));
    }


    @Test
    public void testRace() {
        RaceHorse horse1 = new RaceHorse(10);
        RaceHorse horse2 = new RaceHorse(20);
        RaceHorse horse3 = new RaceHorse(30);
        List<RaceHorse> toRace = new LinkedList<>(Arrays.asList(horse1, horse2, horse3));

        RaceHorse.race(toRace);
        // RaceHorse.updateComparisons(toRace);
        assertTrue(horse1.getSlowerHorses().contains(horse2));
        assertTrue(horse1.getSlowerHorses().contains(horse3));
        assertTrue(horse2.getSlowerHorses().contains(horse3));
        assertTrue(horse2.getFasterHorses().contains(horse1));
        assertTrue(horse3.getFasterHorses().contains(horse1));
        assertTrue(horse3.getFasterHorses().contains(horse2));
    }


    @Test
    public void testUpdateComparisons() {
        RaceHorse horse1 = new RaceHorse(10);
        RaceHorse horse2 = new RaceHorse(20);
        RaceHorse horse3 = new RaceHorse(30);
        List<RaceHorse> allHorses = new LinkedList<>(Arrays.asList(horse1, horse2, horse3));
        List<RaceHorse> race1 = new LinkedList<>(Arrays.asList(horse1, horse2));
        List<RaceHorse> race2 = new LinkedList<>(Arrays.asList(horse2, horse3));

        RaceHorse.race(race1);
        assertTrue(horse1.getSlowerHorses().contains(horse2));
        
        RaceHorse.race(race2);
        assertTrue(horse2.getSlowerHorses().contains(horse3));
        assertFalse(horse1.getSlowerHorses().contains(horse3));

        RaceHorse.updateComparisons(allHorses);
        assertTrue(horse1.getSlowerHorses().contains(horse3));
        assertTrue(horse3.getFasterHorses().contains(horse1));
    }
}