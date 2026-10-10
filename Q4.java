class MembershipCard {
    static String libraryName;
    static String validUntil;
    String studentName;

    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";
        System.out.println("Library info loaded");
    }

    public MembershipCard(String studentName) {
        this.studentName = studentName;
    }
}

public class Q4 {
    public static void main(String[] args) {
        String[] studentNames = {"Aarav", "Bhavna", "Chirag", "Deepa", "Eshwar"};

        for (String name : studentNames) {
            MembershipCard card = new MembershipCard(name);
            System.out.println("Card issued for: " + card.studentName + " | Library: " + MembershipCard.libraryName + " | Valid Until: " + MembershipCard.validUntil);
        }
    }
}