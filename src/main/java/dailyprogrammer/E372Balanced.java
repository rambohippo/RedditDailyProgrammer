package dailyprogrammer;

import java.util.*;

public class E372Balanced {

    public static boolean balanced(String input) {
        int xCount = 0;
        int yCount = 0;
        char currentChar;

        for (int i = 0; i < input.length(); i++) {
            currentChar = input.charAt(i);

            if (currentChar == 'x') {
                xCount++;
            }
            if (currentChar == 'y') {
                yCount++;
            }
        }

        return xCount == yCount;
    }


    public static boolean balanced_bonus(String input) {
        HashMap<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            incrementMapValue(charMap, input.charAt(i));
        }

        Set<Integer> values = new HashSet<Integer>(charMap.values());

        return values.size() <= 1;
    }


    private static void incrementMapValue(Map<Character, Integer> map, Character key) {
        if (map.computeIfPresent(key, (k, v) -> v + 1) == null) {
            map.put(key, 1);
        }
    }
}