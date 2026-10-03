import java.util.Scanner;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class StudentIDPrefixMatcher {

    public static void filterByPrefix(String[] studentIDs, String prefix) throws InvalidInputException {
        if (studentIDs == null || prefix == null) {
            throw new InvalidInputException("Student IDs array and prefix cannot be null.");
        }
        if (studentIDs.length == 0) {
            throw new InvalidInputException("Student IDs list cannot be empty.");
        }

        int count = 0;
        for (String id : studentIDs) {
            if (id != null && id.startsWith(prefix)) {
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Matching IDs Found: 0");
            return;
        }

        String[] matchingIDs = new String[count];
        int index = 0;
        for (String id : studentIDs) {
            if (id != null && id.startsWith(prefix)) {
                matchingIDs[index++] = id;
            }
        }

        System.out.printf("Matching IDs Found: %d | Matches: ", count);
        for (int i = 0; i < matchingIDs.length; i++) {
            System.out.print(matchingIDs[i]);
            if (i < matchingIDs.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            String[] ids = {"2023CS101", "2023EC202", "2023CS105", "2022CS301"};
            filterByPrefix(ids, "2023CS");
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}