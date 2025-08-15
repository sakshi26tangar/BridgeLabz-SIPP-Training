import java.util.*;

public class NameUppercasing {
    public static void main(String[] args) {
        List<String> employeeNames = Arrays.asList("Alice", "Bob", "Charlie");

        employeeNames.stream()
                     .map(String::toUpperCase) // method reference
                     .forEach(System.out::println);
    }
}
