package collectors;
import java.util.*;
import java.util.stream.*;

class Order {
    String customer;
    double total;

    Order(String customer, double total) {
        this.customer = customer;
        this.total = total;
    }
}

public class OrderSummary {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("Alice", 250.5),
            new Order("Bob", 120.0),
            new Order("Alice", 330.0),
            new Order("Bob", 80.0),
            new Order("Charlie", 500.0)
        );

        Map<String, Double> revenue = orders.stream()
            .collect(Collectors.groupingBy(
                o -> o.customer,
                Collectors.summingDouble(o -> o.total)
            ));

        revenue.forEach((customer, sum) -> 
            System.out.println(customer + " -> " + sum));
    }
}