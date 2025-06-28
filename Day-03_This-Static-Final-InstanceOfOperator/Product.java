class Product {
    static double discount = 10.0;
    private final String productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + this.productID);
            System.out.println("Name: " + this.productName);
            System.out.println("Price: $" + this.price);
            System.out.println("Quantity: " + this.quantity);
            System.out.println("Discount: " + discount + "%");
        }
    }

    public static void main(String[] args) {
        Product p1 = new Product("P001", "Laptop", 50000, 2);
        Product p2 = new Product("P002", "Mouse", 500, 5);

        updateDiscount(15.0);
        p1.displayDetails();
        p2.displayDetails();
    }
}
