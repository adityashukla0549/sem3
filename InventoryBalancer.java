import java.util.Scanner;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class InventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) throws InvalidInputException {
        if (sectionA == null || sectionB == null) {
            throw new InvalidInputException("Section inventory arrays cannot be null.");
        }
        if (sectionA.length != sectionB.length) {
            throw new InvalidInputException("Both sections must have the same number of items.");
        }
        if (sectionA.length == 0) {
            throw new InvalidInputException("Sections cannot be empty.");
        }

        int totalA = 0;
        int totalB = 0;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int maxQuantity = sectionA[0];
        String maxSection = "Section A";
        int maxIndex = 1;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > maxQuantity) {
                maxQuantity = sectionA[i];
                maxSection = "Section A";
                maxIndex = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > maxQuantity) {
                maxQuantity = sectionB[i];
                maxSection = "Section B";
                maxIndex = i + 1;
            }
        }

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)\n",
                totalA, totalB, status, maxQuantity, maxSection, maxIndex);
    }

    public static void main(String[] args) {
        try {
            int[] sectionA = {20, 15, 30};
            int[] sectionB = {25, 10, 30};
            analyzeInventory(sectionA, sectionB);
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}