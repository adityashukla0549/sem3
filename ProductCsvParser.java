import java.util.Scanner;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class ProductCsvParser {

    public static void parseInventoryRecord(String csvLine) throws InvalidInputException {
        if (csvLine == null) {
            throw new InvalidInputException("CSV line cannot be null.");
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        System.out.printf("Product: %s | SKU: %s | Qty: %s\n", productName, sku, quantity);
    }

    public static void main(String[] args) {
        try {
            parseInventoryRecord("Wireless Mouse,WM-2201,150");
            parseInventoryRecord("Wireless Mouse,150");
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}