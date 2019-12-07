package dailyprogrammer;

public class E380MorseCode {

    private static final String MORSE_CHARS = ".- -... -.-. -.. . ..-. --."
        + " .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...-"
        + " .-- -..- -.-- --..";

    
    public static String smorse(String input) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            builder.append(getMorseChar(input.charAt(i)));
        }

        return builder.toString();
    }


    private static String getMorseChar(char letter) {
        String[] morseCharArr = MORSE_CHARS.split(" ");
        int charAsInt = Character.getNumericValue(letter);
        return morseCharArr[charAsInt - 10];
    }
}