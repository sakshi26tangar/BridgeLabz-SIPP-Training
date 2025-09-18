import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class GetClassInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a class name (e.g., java.util.ArrayList): ");
        String className = scanner.nextLine();
        
        try {
            // Load the class
            Class<?> clazz = Class.forName(className);
            
            System.out.println("\n=== Class Information ===");
            System.out.println("Class Name: " + clazz.getName());
            System.out.println("Simple Name: " + clazz.getSimpleName());
            System.out.println("Package: " + clazz.getPackage().getName());
            
            // Display constructors
            System.out.println("\n=== Constructors ===");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor.toString());
            }
            
            // Display fields
            System.out.println("\n=== Fields ===");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("Field: " + field.getType().getSimpleName() + " " + field.getName());
            }
            
            // Display methods
            System.out.println("\n=== Methods ===");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Method: " + method.getReturnType().getSimpleName() + " " + 
                                 method.getName() + "()");
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        scanner.close();
    }
}