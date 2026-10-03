import java.util.Scanner;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) throws InvalidInputException {
        if (sentence == null) {
            throw new InvalidInputException("Sentence cannot be null.");
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder wordBuilder = new StringBuilder(words[i]);
            result.append(wordBuilder.reverse().toString());

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        try {
            String input = "hello club";
            String output = reverseEachWord(input);
            System.out.println(output);
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}