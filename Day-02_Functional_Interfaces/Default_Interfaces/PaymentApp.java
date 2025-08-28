package Default_Interfaces;

interface PaymentProcessor {
    void processPayment(double amount);

    default void refund(double amount) {
        System.out.println("Refund of " + amount + " initiated (default implementation).");
    }
}

class PayPalProcessor implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("PayPal processed payment of $" + amount);
    }
}

class StripeProcessor implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Stripe processed payment of $" + amount);
    }

    
    public void refund(double amount) {
        System.out.println("Stripe refund of $" + amount + " processed successfully.");
    }
}

public class PaymentApp {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalProcessor();
        PaymentProcessor stripe = new StripeProcessor();

        paypal.processPayment(100);
        paypal.refund(50);  

        stripe.processPayment(200);
        stripe.refund(75);  
    }
}

