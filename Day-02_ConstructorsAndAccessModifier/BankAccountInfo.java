public class BankAccountInfo {
    public long accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccountInfo(long accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccountInfo extends BankAccountInfo {
    public SavingsAccountInfo(long accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void displayAccountDetails() {
        System.out.println("Account No: " + accountNumber + ", Holder: " + accountHolder);
    }

    public static void main(String[] args) {
        SavingsAccountInfo sa = new SavingsAccountInfo(1002300405, "Neha", 10000);
        sa.displayAccountDetails();
        sa.deposit(2500);
        System.out.println("Updated Balance: ₹" + sa.getBalance());
    }
}
