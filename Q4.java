interface Printable {
    String printLabel();
}

interface Exportable {
    String exportData();
}

class InvoiceQ4 implements Printable, Exportable {
    private String invoiceNumber;
    private double amount;

    public InvoiceQ4(String invoiceNumber, double amount) {
        this.invoiceNumber = invoiceNumber;
        this.amount = amount;
    }

    @Override
    public String printLabel() {
        return "Invoice label: " + invoiceNumber;
    }

    @Override
    public String exportData() {
        return "CSV: " + invoiceNumber + "," + amount;
    }
}

class ShippingDocumentQ4 implements Printable, Exportable {
    private String trackingId;
    private String destination;

    public ShippingDocumentQ4(String trackingId, String destination) {
        this.trackingId = trackingId;
        this.destination = destination;
    }

    @Override
    public String printLabel() {
        return "Package label: " + trackingId;
    }

    @Override
    public String exportData() {
        return "CSV: " + trackingId + "," + destination;
    }
}

public class Q4 {
    public static void processPrintables(Printable[] items) {
        for (Printable item : items) {
            System.out.println(item.printLabel());
        }
    }

    public static void processExportables(Exportable[] items) {
        for (Exportable item : items) {
            System.out.println(item.exportData());
        }
    }

    public static void main(String[] args) {
        InvoiceQ4 inv = new InvoiceQ4("INV-101", 250.50);
        ShippingDocumentQ4 doc = new ShippingDocumentQ4("TRK-999", "New York");

        processPrintables(new Printable[]{inv, doc});
        processExportables(new Exportable[]{inv, doc});
    }
}