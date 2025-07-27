import java.util.*;

public class MarketPlace {
    public static void main(String[] args) {
        List<Product<? extends Category>> catalog = new ArrayList<>();

        Product<BookCategory> book = new Product<>("Atomic Habits", 499.0, BookCategory.NON_FICTION);
        Product<ClothingCategory> tshirt = new Product<>("Graphic Tee", 999.0, ClothingCategory.MENS);
        Product<GadgetCategory> phone = new Product<>("Smartphone X", 24999.0, GadgetCategory.MOBILE);

        catalog.add(book);
        catalog.add(tshirt);
        catalog.add(phone);

        System.out.println("Catalog Before Discount:");
        for (Product<? extends Category> p : catalog) {
            System.out.println(p);
        }

        System.out.println("\npplying Discounts:");
        Product.applyDiscount(book, 10);
        Product.applyDiscount(tshirt, 15);
        Product.applyDiscount(phone, 5);

        System.out.println("\nCatalog After Discount:");
        for (Product<? extends Category> p : catalog) {
            System.out.println(p);
        }
    }
}
