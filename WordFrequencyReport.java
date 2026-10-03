import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class WordFrequencyReport {

    public static void printFilteredWordFrequency(String feedback) throws InvalidInputException {
        if (feedback == null || feedback.trim().isEmpty()) {
            throw new InvalidInputException("Feedback text cannot be null or empty.");
        }

        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        String cleaned = feedback.toLowerCase()
                                .replace(".", "")
                                .replace(",", "")
                                .replace("!", "")
                                .replace("?", "");

        String[] words = cleaned.split("\\s+");

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) continue;

            boolean isStopWord = false;
            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        try {
            String input = "The mentor was great, the session was great and clear.";
            printFilteredWordFrequency(input);
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}