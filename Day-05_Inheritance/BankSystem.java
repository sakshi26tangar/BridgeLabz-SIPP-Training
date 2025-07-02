package com.bridgelaz;

// Base class
class BankAccount {
    String accountNumber;
    double balance;

    public BankAccount(String accNum, double balance) {
        this.accountNumber = accNum;
        this.balance = balance;
    }

    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

// Subclass 1: Savings Account
class SavingsAccount extends BankAccount {
    double interestRate;

    public SavingsAccount(String accNum, double balance, double interestRate) {
        super(accNum, balance);
        this.interestRate = interestRate;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Subclass 2: Checking Account
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    public CheckingAccount(String accNum, double balance, double limit) {
        super(accNum, balance);
        this.withdrawalLimit = limit;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: ₹" + withdrawalLimit);
    }
}

// Subclass 3: Fixed Deposit Account
class FixedDepositAccount extends BankAccount {
    int depositTermMonths;

    public FixedDepositAccount(String accNum, double balance, int term) {
        super(accNum, balance);
        this.depositTermMonths = term;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Deposit Term: " + depositTermMonths + " months");
    }
}

// Demo class
public class BankDemo {
    public static void main(String[] args) {
        SavingsAccount s = new SavingsAccount("SA123", 15000, 3.5);
        CheckingAccount c = new CheckingAccount("CA456", 25000, 10000);
        FixedDepositAccount f = new FixedDepositAccount("FD789", 50000, 12);

        s.displayInfo();
        s.displayAccountType();
        System.out.println("----");

        c.displayInfo();
        c.displayAccountType();
        System.out.println("----");

        f.displayInfo();
        f.displayAccountType();
    }
}
