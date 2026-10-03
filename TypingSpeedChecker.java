public class TypingSpeedChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input: Input strings cannot be null.");
            return;
        }

        if (original.length() != typed.length()) {
            System.out.println("Error: Original and typed strings must be of equal length.");
            return;
        }

        int totalChars = original.length();
        int matchedChars = 0;
        int firstMismatchPos = -1;
        char origChar = ' ', typedChar = ' ';

        for (int i = 0; i < totalChars; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedChars++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-based index
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        double accuracy = ((double) matchedChars / totalChars) * 100;

        String result = String.format("Matched: %d/%d | Accuracy: %.2f%% | ", matchedChars, totalChars, accuracy);
        if (firstMismatchPos != -1) {
            result += String.format("First Mismatch at position %d ('%c' vs '%c')", firstMismatchPos, origChar, typedChar);
        } else {
            result += "No Mismatches";
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}