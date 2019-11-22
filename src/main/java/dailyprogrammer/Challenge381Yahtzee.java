package dailyprogrammer;

import java.util.*;

public class Challenge381Yahtzee {


    public static void main(String[] args) {
        System.out.println(Challenge381Yahtzee.yahtzee_upper(new int[] {1, 2}));
    }

    public static int yahtzee_upper(int[] diceRolls) {
        HashMap<Integer, Integer> diceMap = new HashMap<>();

        for (int i = 0; i < diceRolls.length; i++) {
            incrementMapValue(diceMap, diceRolls[i]);
        }

        return Collections.max(diceMap.entrySet(), (entry1, entry2) ->
            (entry1.getValue() - entry2.getValue())).getValue();
    }


    public static int yahtzee_upper_integer_compare(int[] diceRolls) {
        return findMaxWithIntegerCompare(diceRollsToMap(diceRolls));
    }


    public static int yahtzee_upper_stream(int[] diceRolls) {
        return findMaxWithStream(diceRollsToMap(diceRolls));
    }


    public static int yahtzee_upper_comparator(int[] diceRolls) {
        return findMaxComparator(diceRollsToMap(diceRolls));
    }


    public static int yahtzee_upper_comparing_int(int[] diceRolls) {
        return findMaxComparingInt(diceRollsToMap(diceRolls));
    }


    private static void incrementMapValue(Map<Integer, Integer> map, Integer key) {
        if (map.computeIfPresent(key, (k, v) -> v.intValue() + k.intValue()) == null) {
            map.put(key, key);
        }
    }


    private static Map<Integer, Integer> diceRollsToMap(int[] diceRolls) {
        HashMap<Integer, Integer> diceMap = new HashMap<>();

        for (int i = 0; i < diceRolls.length; i++) {
            incrementMapValue(diceMap, diceRolls[i]);
        }

        return diceMap;
    }

    
    private static Integer findMaxWithIntegerCompare(Map<Integer, Integer> diceRolls) {
        return diceRolls.entrySet().stream().max((entry1, entry2) ->
            Integer.compare(entry1.getValue(), entry2.getValue())).get().getValue();
    }


    private static Integer findMaxWithStream(Map<Integer, Integer> map) {
        return map.entrySet().stream().max((entry1, entry2) ->
            entry1.getValue() > entry2.getValue() ? 1 : -1).get().getValue();
    }


    private static Integer findMaxComparator(Map<Integer, Integer> map) {
        return Collections.max(map.entrySet(), (entry1, entry2) ->
            (entry1.getValue() - entry2.getValue())).getValue();
    }


    private static Integer findMaxComparingInt(Map<Integer, Integer> map) {
        return Collections.max(map.entrySet(),
            Comparator.comparingInt(Map.Entry::getValue)).getValue();
    }
}