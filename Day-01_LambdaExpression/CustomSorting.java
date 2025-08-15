import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    double discount;

    Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return name + " | Price: " + price + " | Rating: " + rating + " | Discount: " + discount + "%";
    }
}

public class CustomSorting {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 75000, 4.5, 10),
            new Product("Phone", 50000, 4.7, 15),
            new Product("Headphones", 2000, 4.2, 25)
        );

        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        System.out.println("Sorted by Price: " + products);

        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        System.out.println("Sorted by Rating: " + products);

        products.sort((p1, p2) -> Double.compare(p2.discount, p1.discount));
        System.out.println("Sorted by Discount: " + products);
    }
}
