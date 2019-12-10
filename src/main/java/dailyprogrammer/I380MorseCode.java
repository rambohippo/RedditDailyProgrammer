package dailyprogrammer;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

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


    /**
     * Finds one possible decoding of the morese code input
     * @param input Smooshed morse code that is a permutation of the alphabet
     * @return One possible decoding of the morse code input
     */
    public static String smalphaFirstResult(String input) {
        MorseTree tree = new MorseTree(input);
        return tree.findFirstResult();
    }


    /**
     * Decodes all smooshed morse code strings in the file "smorse2-bonus1.in".
     * Returns the time in milliseconds that it took to find a decoding for
     * each of the lines contained in the file
     * @return Time in milliseconds to decode the entire input file
     */
    public static long smalphaBonus1() {
        long start = 0;
        long end = 0;
        try {
            Path morseInputPath = Paths.get("smorse2-bonus1.in");
            List<String> allLines = Files.readAllLines(morseInputPath);
            start = System.currentTimeMillis();
            // allLines.forEach(line -> System.out.println(smalphaFirstResult(line)));
            allLines.forEach(line -> smalphaFirstResult(line));
            end = System.currentTimeMillis();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return end - start;
    }
}


class MorseTree {

    private static final String MORSE_CHARS = ".- -... -.-. -.. . ..-. --."
        + " .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...-"
        + " .-- -..- -.-- --..";
    private static final String ENGLISH_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private MorseTreeNode root;

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
        node.getChildren().removeAll(node.getChildren().stream()
            .filter(child -> child.isMarkedForDelete())
            .collect(Collectors.toList()));
    }


    public String findFirstResult() {
        return findFirstResultByNode(root);
    }

    private static String findFirstResultByNode(MorseTreeNode node) {
        node.addChildrenIfPossible();
        for (MorseTreeNode child : node.getChildren()) {
            if (child.getRemainingChars().size() == 0) {
                return child.getDecodedOutput();
            } else {
                String resultString = findFirstResultByNode(child);
                if (resultString != "") {
                    return resultString;
                }
            }
        }
        return "";
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


    /**
     * A node in the morse tree that holds the current decoded string, the
     * remaining input characters, the remaining morese code characters
     * that have not been used, and up to 4 children.
     */
    @SuppressWarnings("unused")
    private class MorseTreeNode {

        private MorseTreeNode parent;
        private List<MorseTreeNode> children;
        private HashMap<String, String> remainingChars;
        private String remainingInput;
        private String decodedOutput;
        private boolean markedForDelete;

        @SuppressWarnings("unchecked")
        public MorseTreeNode(HashMap<String, String> remainingChars,
            String remainingInput, String decodedOutput,
            MorseTreeNode parent) {
            this.parent = parent;
            this.remainingInput = remainingInput;
            this.remainingChars = (HashMap<String, String>) remainingChars.clone();
            this.children = new ArrayList<>();
            this.decodedOutput = decodedOutput;
            this.markedForDelete = false;
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


        public boolean isMarkedForDelete() {
            return markedForDelete;
        }


        public void removeCharsFromRemainingInput(int start, int end) {
            StringBuilder builder = new StringBuilder(remainingInput);
            builder.delete(start, end);
            remainingInput = builder.toString();
        }


        public void addChildrenIfPossible() {
            for (int i = 4; i >= 1; i--) {
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

            markedForDelete = this.getChildren().size() == 0 && this.getRemainingChars().size() > 0;
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