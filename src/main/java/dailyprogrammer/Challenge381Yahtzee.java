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


    private static void incrementMapValue(Map<Integer, Integer> map, Integer key) {
        if (map.computeIfPresent(key, (k, v) -> v.intValue() + k.intValue()) == null) {
            map.put(key, key);
        }
    }
}