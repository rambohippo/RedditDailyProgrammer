package dailyprogrammer;

import java.util.*;
import java.util.stream.Collectors;

public class E298Parentheses {

    public static String removeExtraParentheses(String input) {
        Stack<CharLocation> operatingStack = new Stack<>();
        List<CharLocation> resultList = new ArrayList<>();
        List<CharLocation> tempList = new ArrayList<>();
        String contents = "";
        char currChar;

        for (int i = 0; i < input.length(); i++) {
            currChar = input.charAt(i);
            if (currChar == '(') {
                operatingStack.push(new CharLocation(currChar, i));
            } else if (currChar == ')') {
                if (operatingStack.peek().getChar() != '(') {
                    tempList.add(new CharLocation(currChar, i));
                    while (operatingStack.peek().getChar() != '(') {
                        tempList.add(operatingStack.pop());
                    }
                    tempList.add(operatingStack.pop());
                    operatingStack.push(new CharLocation('~', -1));
                } else {
                    operatingStack.pop();
                }

                long numTilde = tempList.stream().filter(item -> item.getChar() == '~').count();

                if (numTilde > 1) {
                    List<CharLocation> onlyParens = tempList.stream()
                        .filter(item -> item.getChar() == '(' || item.getChar() == ')')
                        .collect(Collectors.toList());
                    resultList.addAll(onlyParens);
                } else if (numTilde == 0) {
                    resultList.addAll(tempList);
                } else if (tempList.size() > 3) {
                    List<CharLocation> noTilde = tempList.stream()
                        .filter(item -> item.getChar() != '~')
                        .collect(Collectors.toList());
                    resultList.addAll(noTilde);
                }
                tempList.removeAll(tempList);
            } else {
                if (operatingStack.isEmpty() || (operatingStack.size() == 1
                    && operatingStack.peek().getChar() == '~')) {
                    resultList.add(new CharLocation(currChar, i));
                } else {
                    operatingStack.push(new CharLocation(currChar, i));
                }
            }
        }

        // Sort and print results
        Collections.sort(resultList, (item1, item2) ->
            item1.getIndex() - item2.getIndex());

        for (CharLocation item : resultList) {
            contents += item.getChar();
            // System.out.printf("%s:%s\n", item.getChar(), item.getIndex());
        }

        return contents;
    }
}


class CharLocation {

    char item;
    int index;

    public CharLocation(char item, int index) {
        this.item = item;
        this.index = index;
    }

    public char getChar() {
        return item;
    }

    public int getIndex() {
        return index;
    }
}