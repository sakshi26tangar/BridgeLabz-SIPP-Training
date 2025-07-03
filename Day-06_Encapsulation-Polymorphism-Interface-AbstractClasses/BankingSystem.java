import java.util.*;

interface Loanable {
    boolean applyForLoan(double amount);
    String calculateLoanEligibility();
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount + ". New Balance: ₹" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew ₹" + amount + ". Remaining Balance: ₹" + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public abstract double calculateInterest();

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name  : " + holderName);
        System.out.println("Balance      : ₹" + balance);
        System.out.println("Interest     : ₹" + calculateInterest());
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        this.balance = amount;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accNo, String holderName, double balance) {
        super(accNo, holderName, balance);
    }

    public double calculateInterest() {
        return getBalance() * 0.04;
    }

    public boolean applyForLoan(double amount) {
        return amount <= (getBalance() * 5);
    }

    public String calculateLoanEligibility() {
        return "Eligible Loan Amount (Savings): ₹" + (getBalance() * 5);
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(String accNo, String holderName, double balance) {
        super(accNo, holderName, balance);
    }

    public double calculateInterest() {
        return 0;
    }

    public boolean applyForLoan(double amount) {
        return amount <= (getBalance() * 3);
    }

    public String calculateLoanEligibility() {
        return "Eligible Loan Amount (Current): ₹" + (getBalance() * 3);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        SavingsAccount s1 = new SavingsAccount("SB101", "Prakhar", 10000);
        CurrentAccount c1 = new CurrentAccount("CA202", "Sakshi", 20000);

        accounts.add(s1);
        accounts.add(c1);

        System.out.println("=== Banking System Summary ===");
        for (BankAccount acc : accounts) {
            System.out.println("\n-----------------------------");
            acc.displayAccountDetails();

            if (acc instanceof Loanable) {
                Loanable loan = (Loanable) acc;
                System.out.println(loan.calculateLoanEligibility());
                boolean approved = loan.applyForLoan(25000);
                System.out.println("Loan Application for ₹25000: " + (approved ? "Approved ✅" : "Rejected ❌"));
            }
        }
    }
}
