import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Student {
    private String name;
    private int age;
    
    // Default constructor
    public Student() {
        this.name = "Unknown";
        this.age = 0;
    }
    
    // Parameterized constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void displayInfo() {
        System.out.println("Student: " + name + ", Age: " + age);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

public class DynamicallyCreateObjects {
    public static void main(String[] args) {
        try {
            // Method 1: Using Class.newInstance() (deprecated)
            System.out.println("=== Method 1: Using default constructor ===");
            Class<?> studentClass = Class.forName("Student");
            Student student1 = (Student) studentClass.getDeclaredConstructor().newInstance();
            System.out.println("Created: " + student1);
            
            // Method 2: Using Constructor.newInstance()
            System.out.println("\n=== Method 2: Using parameterized constructor ===");
            Constructor<?> constructor = studentClass.getConstructor(String.class, int.class);
            Student student2 = (Student) constructor.newInstance("Alice", 20);
            System.out.println("Created: " + student2);
            
            // Method 3: Dynamic object creation with field setting
            System.out.println("\n=== Method 3: Dynamic object with field setting ===");
            Student student3 = (Student) studentClass.getDeclaredConstructor().newInstance();
            
            // Set fields using reflection
            Field nameField = studentClass.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(student3, "Bob");
            
            Field ageField = studentClass.getDeclaredField("age");
            ageField.setAccessible(true);
            ageField.set(student3, 22);
            
            System.out.println("Created and configured: " + student3);
            
            // Method 4: Dynamic method invocation
            System.out.println("\n=== Method 4: Dynamic method invocation ===");
            Student student4 = (Student) studentClass.getDeclaredConstructor().newInstance();
            
            Method setNameMethod = studentClass.getMethod("setName", String.class);
            setNameMethod.invoke(student4, "Charlie");
            
            Method setAgeMethod = studentClass.getMethod("setAge", int.class);
            setAgeMethod.invoke(student4, 25);
            
            Method displayMethod = studentClass.getMethod("displayInfo");
            displayMethod.invoke(student4);
            
            // Demonstrate creating different types of objects
            System.out.println("\n=== Creating different object types ===");
            createAndDisplayObject("java.util.ArrayList");
            createAndDisplayObject("java.util.HashMap");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void createAndDisplayObject(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            Object obj = clazz.getDeclaredConstructor().newInstance();
            System.out.println("Created: " + obj.getClass().getSimpleName());
        } catch (Exception e) {
            System.out.println("Failed to create " + className + ": " + e.getMessage());
        }
    }
}