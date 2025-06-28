import java.util.Scanner;

public class CoffeeCounterChronicles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double gstRate = 0.18; // 18% GST
        
        while (true) {
            System.out.print("Enter coffee type (espresso/latte/cappuccino/mocha) or 'exit' to stop: ");
            String type = sc.nextLine().toLowerCase();
            
            if (type.equals("exit")) {
                break;
            }

            int price;
            switch (type) {
                case "espresso":
                    price = 100;
                    break;
                case "latte":
                    price = 120;
                    break;
                case "cappuccino":
                    price = 130;
                    break;
                case "mocha":
                    price = 150;
                    break;
                default:
                    System.out.println("Invalid coffee type.");
                    continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine(); // Consume leftover newline

            int total = price * quantity;
            double gst = total * gstRate;
            double finalAmount = total + gst;

            System.out.println("Subtotal: ₹" + total);
            System.out.println("GST (18%): ₹" + gst);
            System.out.println("Total Amount: ₹" + finalAmount);
            System.out.println("--------");
        }

        System.out.println("Café closed. Thank you!");
        sc.close();
    }
}
