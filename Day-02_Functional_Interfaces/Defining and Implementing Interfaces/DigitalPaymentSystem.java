interface Payment {
    void pay(double amount);
}

class UPI implements Payment {
    public void pay(double amount) { System.out.println("Paid " + amount + " via UPI"); }
}

class CreditCard implements Payment {
    public void pay(double amount) { System.out.println("Paid " + amount + " via Credit Card"); }
}

class Wallet implements Payment {
    public void pay(double amount) { System.out.println("Paid " + amount + " via Wallet"); }
}

public class DigitalPaymentSystem {
    public static void main(String[] args) {
        Payment upi = new UPI();
        Payment cc = new CreditCard();
        Payment wallet = new Wallet();
        upi.pay(500);
        cc.pay(1200);
        wallet.pay(300);
    }
}
