import java.util.*;

class Invoice {
    String transactionID;

    Invoice(String transactionID) {
        this.transactionID = transactionID;
    }

    @Override
    public String toString() {
        return "Invoice for Transaction: " + transactionID;
    }
}

public class InvoiceCreation {
    public static void main(String[] args) {
        List<String> transactionIDs = Arrays.asList("TXN1001", "TXN1002", "TXN1003");

        // Constructor reference Invoice::new
        List<Invoice> invoices = transactionIDs.stream()
                                                .map(Invoice::new)
                                                .toList();

        invoices.forEach(System.out::println);
    }
}
