package dailyprogrammer;

import java.util.*;
import java.util.Map.Entry;

public class I317CountingElements {

    private String element;
    private String numElement;

    public I317CountingElements() {
        element = "";
        numElement = "";
    }


    public Map<String, Integer> countElements(String input) {
        Map<String, Integer> results = new HashMap<>();
        Map<String, Integer> subSet = new HashMap<>();

        char currChar;
        boolean inSubSet = false;
        boolean endOfSubset = false;

        for (int i = 0; i < input.length(); i++) {
            currChar = input.charAt(i);

            if (Character.isUpperCase(currChar)) {
                if (element != "") {
                    if (inSubSet) {
                        processElement(subSet);
                    } else {
                        processElement(results);
                    }
                    element = "";
                    numElement = "";
                }

                if (endOfSubset && element.equals("")) {
                    combineMapsRepeat(results, subSet, numElement);

                    endOfSubset = false;
                    numElement = "";
                }

                element += currChar;
            } else if (Character.isLowerCase(currChar)) {
                element += currChar;
            } else if (Character.isDigit(currChar)) {
                numElement += currChar;
            } else if (currChar == '(') {
                if (subSet.size() > 0) {
                    combineMapsRepeat(results, subSet, numElement);
                } else {
                    processElement(results);
                }
                element = "";
                numElement = "";
                inSubSet = true;
                endOfSubset = false;
            } else if (currChar == ')') {
                inSubSet = false;
                endOfSubset = true;
                processElement(subSet);
                element = "";
                numElement = "";
            }
        }

        if (subSet.size() > 0) {
            combineMapsRepeat(results, subSet, numElement);
        }

        if (!element.equals("") && !numElement.equals("")) {
            processElement(results);
        }

        return results;
    }


    private void combineMapsRepeat(Map<String, Integer> resultMap,
        Map<String, Integer> secondaryMap, String repeats) {
            int numRepeats;
            if (repeats.equals("")) {
                numRepeats = 0;
            } else {
                numRepeats = Integer.parseInt(repeats);
            }

            for (int i = 0; i < numRepeats; i++) {
                combineMaps(resultMap, secondaryMap);
            }
            secondaryMap.keySet().removeAll(secondaryMap.keySet());
    }


    private void combineMaps(Map<String, Integer> resultMap,
        Map<String, Integer> secondaryMap) {
        for (Entry<String, Integer> entryToAdd : secondaryMap.entrySet()) {
            if (resultMap.computeIfPresent(entryToAdd.getKey(), (k, v) ->
                v + entryToAdd.getValue()) == null) {
                resultMap.put(entryToAdd.getKey(), entryToAdd.getValue());
            }
        }
    }


    private void processElement(Map<String, Integer> elementMap) {
        if (numElement.equals("")) {
            numElement = "1";
        }
        int numElementInt = Integer.parseInt(numElement);
        increaseMapValue(elementMap, element, numElementInt);
    }


    private void increaseMapValue(Map<String, Integer> elementMap,
        String elementName, int numElementInt) {
        if (elementMap.computeIfPresent(elementName, (k, v) ->
            v.intValue() + numElementInt) == null) {
            elementMap.put(elementName, numElementInt);
        }
    }
}