package Marker_Interface;

// Custom Marker Interface
interface SensitiveData {
    // no methods (marker only)
}

class CreditCardInfo implements SensitiveData {
    private String cardNumber;
    private String holderName;

    public CreditCardInfo(String cardNumber, String holderName) {
        this.cardNumber = cardNumber;
        this.holderName = holderName;
    }

    public String toString() {
        return "CreditCardInfo{holder='" + holderName + "'}";
    }
}

public class DataTagging {
    public static void main(String[] args) {
        CreditCardInfo card = new CreditCardInfo("1234-5678-9876-5432", "Sakshi Tangar");

        // Check if object is sensitive
        if (card instanceof SensitiveData) {
            System.out.println("⚠ Data is sensitive, apply encryption before storage.");
        } else {
            System.out.println("Data is safe.");
        }
    }
}

