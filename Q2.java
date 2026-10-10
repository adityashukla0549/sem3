class MovieTicket {
    private String seatNumber;
    String screenId;
    protected double ticketPrice;
    public String movieTitle;

    public MovieTicket(String seatNumber, String screenId, double ticketPrice, String movieTitle) {
        this.seatNumber = seatNumber;
        this.screenId = screenId;
        this.ticketPrice = ticketPrice;
        this.movieTitle = movieTitle;
    }
}

class AccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if ("SAME_CLASS".equals(accessorContext)) {
            return "ALLOWED";
        }

        if ("SAME_PACKAGE".equals(accessorContext)) {
            if ("private".equals(fieldModifier)) {
                return "DENIED";
            }
            return "ALLOWED";
        }

        if ("DIFFERENT_PACKAGE".equals(accessorContext)) {
            if ("public".equals(fieldModifier)) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        if ("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext)) {
            if ("protected".equals(fieldModifier) || "public".equals(fieldModifier)) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        if ("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE".equals(accessorContext)) {
            if ("public".equals(fieldModifier)) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        return "DENIED";
    }

    public static String summarizeBatch(String[][] attempts) {
        int allowedCount = 0;
        int deniedCount = 0;

        for (String[] attempt : attempts) {
            String result = classifyAccess(attempt[0], attempt[1]);
            if ("ALLOWED".equals(result)) {
                allowedCount++;
            } else {
                deniedCount++;
            }
        }

        return "Allowed: " + allowedCount + " | Denied: " + deniedCount;
    }
}

public class Q2 {
    public static void main(String[] args) {
        System.out.println(AccessChecker.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println(AccessChecker.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}