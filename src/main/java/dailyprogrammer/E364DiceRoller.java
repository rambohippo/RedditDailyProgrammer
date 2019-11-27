package dailyprogrammer;

import java.util.*;
import java.util.stream.Collectors;

public class E364DiceRoller {

    public static void main(String[] args) {
        String userInput = "";
        Scanner in = new Scanner(System.in);

        while (!userInput.equals("quit")) {
            System.out.print("Enter dice to roll ('quit' to exit): ");
            userInput = in.nextLine();

            if (!userInput.equals("quit")) {
                parseInputAndRoll(userInput);
            }
        }

        in.close();
    }


    private static void parseInputAndRoll(String diceToRoll) {
        int numDice;
        int numSides;
        int bonus = 0;
        String[] inputs = diceToRoll.split("d");

        try {
            numDice = Integer.parseInt(inputs[0].trim());
            String[] rightSide = inputs[1].split("\\+|-");
            if (rightSide.length > 1) {
                numSides = Integer.parseInt(rightSide[0].trim());
                bonus = Integer.parseInt(rightSide[1].trim());
                if (inputs[1].contains("-")) {
                    bonus *= -1;
                }
            } else {
                numSides = Integer.parseInt(inputs[1].trim());
            }

            rollAndPrint(numDice, numSides, bonus);
        } catch (Exception ex) {
            System.out.printf("Input format is incorrect.\nYou entered: %s\nRequired format: '#d#'\n",
                diceToRoll);
        }
    }


    private static List<Integer> rollDice(int numDice, int numSides, int bonus) {
        List<Integer> rolls = rollDice(numDice, numSides);
        rolls.add(bonus);
        return rolls;
    }


    private static List<Integer> rollDice(int numDice, int numSides) {
        Random dice = new Random();
        // int[] rolls = new int[numDice];
        List<Integer> rolls = new ArrayList<>();

        for (int i = 0; i < numDice; i++) {
            rolls.add(dice.nextInt(numSides) + 1);
        }

        return rolls;
    }


    public static void printDiceRolls(int numDice, int numSides, List<Integer> rolls) {
        // Sum roll values
        Integer sum = rolls.stream()
            .mapToInt(Integer::intValue)
            .sum();

        // Pull out roll bonus if there is one
        int bonus = 0;
        String bonusPrefix = "+";
        if (rolls.size() > numDice) {
            bonus = rolls.remove(rolls.size() - 1);
            bonusPrefix = (bonus >= 0) ? "+" : "";
        }

        // Convert rolls to a joined String to print
        List<String> rollsAsStr = rolls.stream()
            .mapToInt(p -> Integer.valueOf(p))
            .mapToObj(String::valueOf)
            .collect(Collectors.toList());
        String printable = String.join(", ", rollsAsStr);
        
        // Print
        System.out.printf("%dd%d", numDice, numSides);
        if (bonus != 0) {
            System.out.printf("%s%d", bonusPrefix, bonus);
        }
        System.out.printf(" -> %d: %s\n", sum, printable);
    }


    private static void rollAndPrint(int numDice, int numSides, int bonus) {
        List<Integer> rolls;
        if (bonus == 0) {
            rolls = rollDice(numDice, numSides);
        } else {
            rolls = rollDice(numDice, numSides, bonus);
        }
        printDiceRolls(numDice, numSides, rolls);
    }
}