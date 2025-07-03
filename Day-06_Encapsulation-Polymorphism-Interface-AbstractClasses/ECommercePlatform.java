import java.util.*;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public abstract double calculateDiscount();

    public int getProductId() {
        return productId;
    }

    public void setProductId(int id) {
        this.productId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }
}

class Electronics extends Product implements Taxable {
    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.10; 
    }

    public double calculateTax() {
        return getPrice() * 0.18; 
    }

    public String getTaxDetails() {
        return "GST: 18% on Electronics";
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.20; 
    }

    public double calculateTax() {
        return getPrice() * 0.12; 
    }

    public String getTaxDetails() {
        return "GST: 12% on Clothing";
    }
}

class Groceries extends Product {
    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.05; 
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Electronics(101, "Laptop", 50000));
        products.add(new Clothing(102, "Jacket", 3000));
        products.add(new Groceries(103, "Rice", 800));

        System.out.println("=== Product Billing Summary ===");

        for (Product p : products) {
            System.out.println("\nProduct ID: " + p.getProductId());
            System.out.println("Name: " + p.getName());
            System.out.println("Base Price: ₹" + p.getPrice());

            double tax = 0;
            if (p instanceof Taxable) {
                Taxable t = (Taxable) p;
                tax = t.calculateTax();
                System.out.println(t.getTaxDetails());
                System.out.println("Tax: ₹" + tax);
            } else {
                System.out.println("No Tax Applied");
            }

            double discount = p.calculateDiscount();
            System.out.println("Discount: ₹" + discount);

            double finalPrice = p.getPrice() + tax - discount;
            System.out.println("Final Price: ₹" + finalPrice);
        }
    }
}
