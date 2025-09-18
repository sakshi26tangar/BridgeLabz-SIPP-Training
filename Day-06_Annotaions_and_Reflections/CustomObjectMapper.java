import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class Person {
    private String name;
    private int age;
    private String email;
    private double salary;
    
    public Person() {}
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", email='" + email + "', salary=" + salary + "}";
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}

class Employee {
    private String employeeId;
    private String department;
    private double salary;
    
    public Employee() {}
    
    @Override
    public String toString() {
        return "Employee{employeeId='" + employeeId + "', department='" + department + "', salary=" + salary + "}";
    }
}

public class CustomObjectMapper {
    
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create instance using default constructor
            T instance = clazz.getDeclaredConstructor().newInstance();
            
            // Iterate through properties and set fields
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();
                
                try {
                    // Find the field
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    
                    // Handle type conversion
                    Object convertedValue = convertType(fieldValue, field.getType());
                    field.set(instance, convertedValue);
                    
                } catch (NoSuchFieldException e) {
                    // Field not found, skip or log warning
                    System.out.println("Warning: Field '" + fieldName + "' not found in " + clazz.getSimpleName());
                }
            }
            
            return instance;
            
        } catch (Exception e) {
            throw new RuntimeException("Failed to create object", e);
        }
    }
    
    private static Object convertType(Object value, Class<?> targetType) {
        if (value == null) return null;
        
        // If types already match
        if (targetType.isAssignableFrom(value.getClass())) {
            return value;
        }
        
        // Handle primitive type conversions
        String stringValue = value.toString();
        
        if (targetType == String.class) {
            return stringValue;
        } else if (targetType == int.class || targetType == Integer.class) {
            return Integer.parseInt(stringValue);
        } else if (targetType == double.class || targetType == Double.class) {
            return Double.parseDouble(stringValue);
        } else if (targetType == boolean.class || targetType == Boolean.class) {
            return Boolean.parseBoolean(stringValue);
        } else if (targetType == long.class || targetType == Long.class) {
            return Long.parseLong(stringValue);
        } else if (targetType == float.class || targetType == Float.class) {
            return Float.parseFloat(stringValue);
        }
        
        return value;
    }
    
    public static void main(String[] args) {
        // Test with Person class
        Map<String, Object> personProps = new HashMap<>();
        personProps.put("name", "John Doe");
        personProps.put("age", 30);
        personProps.put("email", "john.doe@example.com");
        personProps.put("salary", 75000.50);
        
        Person person = toObject(Person.class, personProps);
        System.out.println("Created Person: " + person);
        
        // Test with Employee class
        Map<String, Object> employeeProps = new HashMap<>();
        employeeProps.put("employeeId", "EMP001");
        employeeProps.put("department", "Engineering");
        employeeProps.put("salary", 85000.0);
        
        Employee employee = toObject(Employee.class, employeeProps);
        System.out.println("Created Employee: " + employee);
        
        // Test with partial properties
        Map<String, Object> partialProps = new HashMap<>();
        partialProps.put("name", "Alice Smith");
        partialProps.put("age", 25);
        
        Person partialPerson = toObject(Person.class, partialProps);
        System.out.println("Partial Person: " + partialPerson);
        
        // Test type conversion
        Map<String, Object> typeTest = new HashMap<>();
        typeTest.put("name", "Bob Johnson");
        typeTest.put("age", "35"); // String to int conversion
        typeTest.put("salary", "90000"); // String to double conversion
        
        Person typeTestPerson = toObject(Person.class, typeTest);
        System.out.println("Type Test Person: " + typeTestPerson);
    }
}