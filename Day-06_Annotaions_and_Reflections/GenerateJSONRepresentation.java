import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

class Product {
    private String name;
    private double price;
    private int quantity;
    private boolean inStock;
    private List<String> categories;
    
    public Product(String name, double price, int quantity, boolean inStock, List<String> categories) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.inStock = inStock;
        this.categories = categories;
    }
    
    public Product() {}
}

class Address {
    private String street;
    private String city;
    private String zipCode;
    
    public Address(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
}

class Customer {
    private String id;
    private String name;
    private Address address;
    private Product favoriteProduct;
    
    public Customer(String id, String name, Address address, Product favoriteProduct) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.favoriteProduct = favoriteProduct;
    }
}

public class GenerateJSONRepresentation {
    
    public static String toJson(Object obj) {
        if (obj == null) {
            return "null";
        }
        
        Class<?> clazz = obj.getClass();
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        
        Field[] fields = clazz.getDeclaredFields();
        boolean first = true;
        
        for (Field field : fields) {
            if (!first) {
                json.append(",\n");
            }
            first = false;
            
            field.setAccessible(true);
            json.append("  \"").append(field.getName()).append("\": ");
            
            try {
                Object value = field.get(obj);
                json.append(formatValue(value));
            } catch (IllegalAccessException e) {
                json.append("\"[ACCESS_DENIED]\"");
            }
        }
        
        json.append("\n}");
        return json.toString();
    }
    
    private static String formatValue(Object value) {
        if (value == null) {
            return "null";
        }
        
        Class<?> type = value.getClass();
        
        if (type == String.class) {
            return "\"" + escapeString(value.toString()) + "\"";
        } else if (type == int.class || type == Integer.class || 
                   type == double.class || type == Double.class ||
                   type == long.class || type == Long.class ||
                   type == float.class || type == Float.class ||
                   type == boolean.class || type == Boolean.class) {
            return value.toString();
        } else if (type.isArray()) {
            return formatArray(value);
        } else if (value instanceof List) {
            return formatList((List<?>) value);
        } else if (type.getName().startsWith("java")) {
            return "\"" + value.toString() + "\"";
        } else {
            // Complex object - use toJson recursively
            return toJson(value);
        }
    }
    
    private static String formatArray(Object array) {
        StringBuilder sb = new StringBuilder("[");
        int length = java.lang.reflect.Array.getLength(array);
        for (int i = 0; i < length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(formatValue(java.lang.reflect.Array.get(array, i)));
        }
        sb.append("]");
        return sb.toString();
    }
    
    private static String formatList(List<?> list) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(formatValue(list.get(i)));
        }
        sb.append("]");
        return sb.toString();
    }
    
    private static String escapeString(String str) {
        return str.replace("\\", "\\\\")
                  .replace("\"", "\\\"")
                  .replace("\n", "\\n")
                  .replace("\r", "\\r")
                  .replace("\t", "\\t");
    }
    
    public static void main(String[] args) {
        // Test with simple object
        Product laptop = new Product(
            "Laptop", 
            999.99, 
            10, 
            true, 
            Arrays.asList("Electronics", "Computers", "Gaming")
        );
        
        System.out.println("=== Product JSON ===");
        System.out.println(toJson(laptop));
        
        // Test with nested objects
        Address address = new Address("123 Main St", "Springfield", "12345");
        Customer customer = new Customer("CUST001", "John Doe", address, laptop);
        
        System.out.println("\n=== Customer JSON ===");
        System.out.println(toJson(customer));
        
        // Test with primitive types
        Product simpleProduct = new Product();
        System.out.println("\n=== Empty Product JSON ===");
        System.out.println(toJson(simpleProduct));
    }
}