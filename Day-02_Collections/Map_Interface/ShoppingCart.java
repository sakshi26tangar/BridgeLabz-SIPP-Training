import java.util.*;

public class ShoppingCart {
    // Product prices
    private HashMap<String, Double> priceMap = new HashMap<>();

    // Cart: product name → quantity (order of insertion preserved)
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();

    // Add a product with price to product list
    public void addProduct(String name, double price) {
        priceMap.put(name, price);
    }

    // Add product to cart
    public void addToCart(String name, int quantity) {
        if (!priceMap.containsKey(name)) {
            System.out.println("❌ Product not found: " + name);
            return;
        }
        cart.put(name, cart.getOrDefault(name, 0) + quantity);
    }

    // Display cart in insertion order
    public void displayCartInOrder() {
        System.out.println("\n🛒 Cart (Insertion Order):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            int qty = entry.getValue();
            double price = priceMap.get(product);
            System.out.println(product + " × " + qty + " @ ₹" + price + " each");
        }
    }

    // Display items sorted by price
    public void displaySortedByPrice() {
        System.out.println("\n📊 Cart Items Sorted by Price:");

        TreeMap<Double, List<String>> priceTree = new TreeMap<>();

        for (String product : cart.keySet()) {
            double price = priceMap.get(product);
            priceTree.putIfAbsent(price, new ArrayList<>());
            priceTree.get(price).add(product);
        }

        for (Map.Entry<Double, List<String>> entry : priceTree.entrySet()) {
            double price = entry.getKey();
            for (String product : entry.getValue()) {
                System.out.println(product + " @ ₹" + price);
            }
        }
    }

    // Display total
    public void displayTotal() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            int qty = entry.getValue();
            total += priceMap.get(product) * qty;
        }
        System.out.println("\n💰 Total: ₹" + total);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Add products and prices
        cart.addProduct("Apple", 40);
        cart.addProduct("Banana", 10);
        cart.addProduct("Milk", 50);
        cart.addProduct("Bread", 30);

        // Add to cart
        cart.addToCart("Milk", 1);
        cart.addToCart("Banana", 5);
        cart.addToCart("Apple", 2);
        cart.addToCart("Bread", 1);

        // Display cart
        cart.displayCartInOrder();
        cart.displaySortedByPrice();
        cart.displayTotal();
    }
}
