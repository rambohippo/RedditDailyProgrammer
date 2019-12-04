package dailyprogrammer;

import java.util.*;
import java.util.stream.*;

public class I304HorseRaceSorting {

    public static int[] sortByRaceTimes(int[] raceTimes) {
        return new int[0];
    }
}


class RaceHorse implements Comparable<RaceHorse> {

    private int raceTime;
    private Set<RaceHorse> slowerHorses;
    private Set<RaceHorse> fasterHorses;

    public RaceHorse(int raceTime) {
        this.raceTime = raceTime;
        slowerHorses = new HashSet<>();
        fasterHorses = new HashSet<>();
    }


    public Set<RaceHorse> getSlowerHorses() {
        return slowerHorses;
    }


    public void setSlowerHorses(Set<RaceHorse> horses) {
        slowerHorses = horses;
    }


    public void addSlowerHorses(Set<RaceHorse> horses) {
        slowerHorses.addAll(horses);
    }


    public Set<RaceHorse> getFasterHorses() {
        return fasterHorses;
    }


    public void setFasterHorses(Set<RaceHorse> horses) {
        fasterHorses = horses;
    }


    public void addFasterHorses(Set<RaceHorse> horses) {
        fasterHorses.addAll(horses);
    }


    public int getRaceTime() {
        return raceTime;
    }


    private void updateSlowerHorses() {
        setSlowerHorses(getAllSlowerHorses());
    }


    private void updateFasterHorses() {
        setFasterHorses(getAllFasterHorses());
    }


    private Set<RaceHorse> getAllSlowerHorses() {
        Set<RaceHorse> slower = new HashSet<>();
        getAllSlowerHorses(slower);
        return slower;
    }


    private Set<RaceHorse> getAllFasterHorses() {
        Set<RaceHorse> faster = new HashSet<>();
        getAllFasterHorses(faster);
        return faster;
    }


    private void getAllSlowerHorses(Set<RaceHorse> slower) {
        for (RaceHorse horse : getSlowerHorses()) {
            slower.add(horse);
            slower.addAll(horse.getAllSlowerHorses());
        }
    }


    private void getAllFasterHorses(Set<RaceHorse> faster) {
        for (RaceHorse horse : getFasterHorses()) {
            faster.add(horse);
            faster.addAll(horse.getAllFasterHorses());
        }
    }
    
    
    @Override
    public int compareTo(RaceHorse horse) {
        return Integer.compare(this.getRaceTime(), horse.getRaceTime());
    }
    
    
    public static void race(List<RaceHorse> allHorses) {
        for (RaceHorse horse : allHorses) {
            Set<RaceHorse> slower = allHorses.stream()
                .filter(item -> horse.compareTo(item) < 0)
                .collect(Collectors.toSet());
            Set<RaceHorse> faster = allHorses.stream()
                .filter(item -> horse.compareTo(item) > 0)
                .collect(Collectors.toSet());

            horse.addSlowerHorses(slower);
            horse.addFasterHorses(faster);
        }
    }
    
    
    public static void updateComparisons(List<RaceHorse> allHorses) {
        for (RaceHorse horse : allHorses) {
            horse.updateSlowerHorses();
            horse.updateFasterHorses();
        }
    }


    public static boolean canBeSorted(List<RaceHorse> allHorses) {
        int numHorses = allHorses.size();
        RaceHorse first = allHorses.get(0);
        // Check if the first horse has connections to all the others
        // Could also attempt to sort each time and continue if it fails
        return first.getFasterHorses().size() + first.getSlowerHorses().size() + 1
            == numHorses;
    }
}