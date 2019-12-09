package dailyprogrammer;

import java.io.*;
import java.util.*;

public class I380MorseCode {

    /**
     * Finds all possible decodings of the morse code input where each letter
     * can only be used once and every letter is used once
     * @param input Smooshed morse code that is a permutation of the alphabet
     * @return List of all possible decodings of the morse code input
     */
    public static List<String> smalpha(String input) {
        MorseTree tree = new MorseTree(input);
        tree.populateTree();
        return tree.getResultsAsList();
    }
}


class MorseTree {

    private static final String MORSE_CHARS = ".- -... -.-. -.. . ..-. --."
        + " .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...-"
        + " .-- -..- -.-- --..";
    private static final String ENGLISH_CHARS = "abcdefghijklmnopqrstuvwxyz";
    MorseTreeNode root;

    public MorseTree(String textInput) {
        this(createMorseCodeMap(), textInput);
    }


    public MorseTree(HashMap<String, String> morseMap, String textInput) {
        root = new MorseTreeNode(morseMap, textInput, "", null);
    }


    private static HashMap<String, String> createMorseCodeMap() {
        HashMap<String, String> codeMap = new HashMap<>();
        String[] morseCharArr = MORSE_CHARS.split(" ");

        for (int i = 0; i < morseCharArr.length; i++) {
            codeMap.put(morseCharArr[i], String.valueOf(ENGLISH_CHARS.charAt(i)));
        }
        return codeMap;
    }


    public void populateTree() {
        populateTreeByNode(root);
    }


    private static void populateTreeByNode(MorseTreeNode node) {
        node.addChildrenIfPossible();
        node.getChildren().forEach(child -> populateTreeByNode(child));
    }


    public void printTreeLeafOnly() {
        printTreeLeafOnly(root);
    }


    private static void printTreeLeafOnly(MorseTreeNode node) {
        // if (node.getRemainingChars().size() == 17) {
        if (node.getRemainingChars().size() == 0) {
            System.out.println("node: " + node.getDecodedOutput());
        }
        node.getChildren().forEach(each -> printTreeLeafOnly(each));
    }


    public void printTreeAllLettersToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            printTreeAllLettersToFile(writer, root);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private static void printTreeAllLettersToFile(Writer writer, MorseTreeNode node) {
        try {
            if (node.getRemainingChars().size() == 0) {
                writer.write("node: " + node.getDecodedOutput() + "\n");
            }
            node.getChildren().forEach(each -> printTreeAllLettersToFile(writer, each));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public List<String> getResultsAsList() {
        List<String> results = new ArrayList<>();
        return getResultsAsList(root, results);
    }


    private static List<String> getResultsAsList(MorseTreeNode node, List<String> results) {
        if (node.getRemainingChars().size() == 0) {
            results.add(node.getDecodedOutput());
        }
        node.getChildren().forEach(each -> getResultsAsList(each, results));
        return results;
    }


    private class MorseTreeNode {

        MorseTreeNode parent;
        List<MorseTreeNode> children;
        HashMap<String, String> remainingChars;
        String remainingInput;
        String decodedOutput;

        @SuppressWarnings("unchecked")
        public MorseTreeNode(HashMap<String, String> remainingChars,
            String remainingInput, String decodedOutput,
            MorseTreeNode parent) {
            this.parent = parent;
            this.remainingInput = remainingInput;
            this.remainingChars = (HashMap<String, String>) remainingChars.clone();
            this.children = new ArrayList<>();
            this.decodedOutput = decodedOutput;
        }


        public List<MorseTreeNode> getChildren() {
            return children;
        }


        public String getDecodedOutput() {
            return decodedOutput;
        }


        public void appendToOutput(String textToAdd) {
            decodedOutput += textToAdd;
        }


        public HashMap<String, String> getRemainingChars() {
            return remainingChars;
        }


        public void removeCharsFromRemainingInput(int start, int end) {
            StringBuilder builder = new StringBuilder(remainingInput);
            builder.delete(start, end);
            remainingInput = builder.toString();
        }


        public void addChildrenIfPossible() {
            for (int i = 1; i <= 4; i++) {
                if (checkForMorseChar(i)) {
                    String morseChar = remainingInput.substring(0, i);
                    MorseTreeNode child = new MorseTreeNode(remainingChars,
                        remainingInput, decodedOutput, this);
                    child.removeCharsFromRemainingInput(0, i);
                    child.getRemainingChars().remove(morseChar);
                    // child.appendToOutput(this.getDecodedOutput());
                    child.appendToOutput(remainingChars.get(morseChar));
                    children.add(child);
                }
            }
        }


        private boolean checkForMorseChar(int length) {
            if (remainingInput.length() == 0 || length > remainingInput.length()) {
                return false;
            }
            String possibleMorseChar = remainingInput.substring(0, length);
            return remainingChars.get(possibleMorseChar) != null;
        }
    }
}