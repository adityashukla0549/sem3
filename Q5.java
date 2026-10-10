class Payment {
}

class CashPayment extends Payment {
}

class UPIPayment extends Payment {
}

class CardPayment extends Payment {
}

public class Q5 {
    public static void processPayment(Payment p) {
        if (p instanceof UPIPayment) {
            System.out.println("Processing UPI payment...");
        } else if (p instanceof CardPayment) {
            System.out.println("Processing Card payment...");
        } else if (p instanceof CashPayment) {
            System.out.println("Processing Cash payment...");
        } else {
            System.out.println("Unknown payment type!");
        }
    }

    public static void main(String[] args) {
        Payment[] payments = {
            new UPIPayment(),
            new CashPayment(),
            new CardPayment(),
            new UPIPayment()
        };

        for (Payment p : payments) {
            processPayment(p);
        }
    }
}