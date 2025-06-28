class Customer {
    String name;
    double balance;

    Customer(String name) {
        this.name = name;
    }

    void viewBalance() {
        System.out.println(name + "'s balance: ₹" + balance);
    }
}

class Bank {
    String name;

    Bank(String name) {
        this.name = name;
    }

    void openAccount(Customer c, double initialDeposit) {
        c.balance = initialDeposit;
        System.out.println("Account opened for " + c.name + " in " + name);
    }
}
