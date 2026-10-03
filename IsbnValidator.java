import java.util.Scanner;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class IsbnValidator {

    public static String normalizeCode(String raw) throws InvalidInputException {
        if (raw == null) {
            throw new InvalidInputException("Code cannot be null.");
        }

        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }

        String publisherCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);

        return publisherCode + rest;
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length (must be 13 characters)";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: remaining body must be digits";
            }
        }

        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalogNumber = code.substring(7, 13);

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(publisherCode).append("] ")
                 .append("YEAR: ").append(year).append(" | ")
                 .append("CATALOG: ").append(catalogNumber);

        return formatted.toString();
    }

    public static void main(String[] args) {
        try {
            String raw1 = " pen2026004251 ";
            String normalized1 = normalizeCode(raw1);
            System.out.println(validateAndFormat(normalized1));

            String raw2 = "12N2026004251";
            String normalized2 = normalizeCode(raw2);
            System.out.println(validateAndFormat(normalized2));
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}