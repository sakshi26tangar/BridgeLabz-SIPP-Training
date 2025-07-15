import java.util.ArrayList;
import java.util.List;

public abstract class Wallet implements Transferable {
    private double balance;
    List<Transaction> history = new ArrayList<>();

    public Wallet(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void loadMoney(double amount) {
        balance += amount;
        history.add(new Transaction("Loaded money", amount));
    }

    protected void deduct(double amount) {
        balance -= amount;
    }

    protected void credit(double amount) {
        balance += amount;
    }

    public void showHistory() {
        for (Transaction t : history) {
            System.out.println(t);
        }
    }
}
