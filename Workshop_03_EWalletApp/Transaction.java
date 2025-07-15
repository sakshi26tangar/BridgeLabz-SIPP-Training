import java.util.Date;

public class Transaction {
    String description;
    double amount;
    Date date;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return date + ": " + description + " ₹" + amount;
    }
}
