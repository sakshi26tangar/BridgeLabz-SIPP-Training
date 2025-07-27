public class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void applyDiscount(double percentage) {
        price = price - (price * percentage / 100.0);
    }

    public static <T extends Category> void applyDiscount(Product<T> product, double percentage) {
        product.applyDiscount(percentage);
        System.out.println("Discount applied to: " + product.name);
    }

    @Override
    public String toString() {
        return name + " | " + category.getCategoryName() + " | ₹" + String.format("%.2f", price);
    }
}
