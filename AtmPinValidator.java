import java.util.Scanner;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class AtmPinValidator {

    public static void checkPinLength(String pin) throws InvalidInputException {
        if (pin == null) {
            throw new InvalidInputException("PIN cannot be null.");
        }

        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        try {
            checkPinLength("482");
            checkPinLength("4820");
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}