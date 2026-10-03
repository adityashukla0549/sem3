public class SeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("Invalid input: Seat array is empty or null.");
            return;
        }

        boolean foundDuplicate = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundDuplicate = true;
                    break; // Move to next element to avoid printing the same pair multiple times
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] test1 = {101, 102, 103, 102, 105};
        int[] test2 = {101, 102, 103, 104, 105};

        checkDuplicateSeats(test1);
        checkDuplicateSeats(test2);
    }
}
