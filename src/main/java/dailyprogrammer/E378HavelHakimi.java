package dailyprogrammer;

import java.util.*;
import java.util.stream.*;

public class E378HavelHakimi {

    // Eliminating 0's
    public static int[] warmup1(int[] input) {
        return IntStream.of(input)
            .filter(i -> i != 0)
            .toArray();
    }


    // Decending sort
    public static int[] warmup2(int[] input) {
        return IntStream.of(input)
            .sorted()
            .boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(Integer::valueOf)
            .toArray();
    }


    // length check
    public static boolean warmup3(int checkNum, int[] input) {
        return checkNum > input.length;
    }


    // Front elimination
    public static int[] warmup4(int frontNum, int[] input) {
        if (frontNum == 0) {
            return input;
        }

        if (frontNum > input.length) {
            frontNum = input.length;
        }

        for (int i = 0; i < frontNum; i++) {
            input[i]--;
        }

        return input;
    }


    /**
     * Full Havel Hakimi Algorithm
     * Recurrsive solution as it seemed to be the most straight forward
     */
    public static boolean havelHakimi(int[] input) {
        // remove zeros
        input = warmup1(input);

        // Check if the input is empty, if so return true
        if (input.length == 0) {
            return true;
        }

        // Sort in descending order
        input = warmup2(input);

        int n = input[0];
        input = Arrays.copyOfRange(input, 1, input.length);
        // Check if the first num is greater than the length of the rest
        // return false if so
        if (warmup3(n, input)) {
            return false;
        }

        // Subtract 1 from the first n elements
        input = warmup4(n, input);

        // Start over from step 1
        return havelHakimi(input);
    }
}