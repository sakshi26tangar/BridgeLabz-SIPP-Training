import java.util.*;

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item Name : " + itemName);
        System.out.println("Price     : ₹" + price);
        System.out.println("Quantity  : " + quantity);
        System.out.println("Total     : ₹" + calculateTotalPrice());
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        return total - applyDiscount();
    }

    public double applyDiscount() {
        return getPrice() * getQuantity() * 0.10;
    }

    public String getDiscountDetails() {
        return "Veg Discount: 10%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        double base = getPrice() * getQuantity();
        double additionalCharge = 50;
        return base + additionalCharge - applyDiscount();
    }

    public double applyDiscount() {
        return getPrice() * getQuantity() * 0.05;
    }

    public String getDiscountDetails() {
        return "Non-Veg Discount: 5% + ₹50 Extra Charge";
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();

        order.add(new VegItem("Paneer Roll", 120, 2));
        order.add(new NonVegItem("Chicken Biryani", 200, 1));

        System.out.println("=== Order Summary ===");
        for (FoodItem item : order) {
            System.out.println("\n-----------------------");
            item.getItemDetails();

            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                System.out.println(d.getDiscountDetails());
                System.out.println("Discount Applied: ₹" + d.applyDiscount());
            }

            System.out.println("Final Payable: ₹" + item.calculateTotalPrice());
        }
    }
}
