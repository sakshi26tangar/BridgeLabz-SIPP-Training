import java.util.*;

class Product {
    String name;

    Product(String name) {
        this.name = name;
    }
}

class Order {
    List<Product> products = new ArrayList<>();

    void addProduct(Product p) {
        products.add(p);
    }

    void listProducts() {
        for (Product p : products) {
            System.out.println(p.name);
        }
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }

    Order placeOrder() {
        return new Order();
    }
}
