import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Custom annotation definition
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@interface Author {
    String name();
    String date() default "Not specified";
    String version() default "1.0";
}

@Author(name = "Alice Developer", date = "2024-01-15", version = "2.0")
class SampleClass {
    
    @Author(name = "Bob Programmer", date = "2024-01-20")
    private String sampleField;
    
    @Author(name = "Charlie Coder", version = "1.5")
    public void sampleMethod() {
        System.out.println("This is a sample method");
    }
    
    @Author(name = "Diana Developer")
    public void anotherMethod() {
        System.out.println("Another method");
    }
}

public class RetrieveAnnotationsAtRuntime {
    public static void main(String[] args) {
        try {
            // Get class annotations
            System.out.println("=== Class Annotations ===");
            Class<?> clazz = SampleClass.class;
            
            if (clazz.isAnnotationPresent(Author.class)) {
                Author author = clazz.getAnnotation(Author.class);
                System.out.println("Class Author: " + author.name());
                System.out.println("Date: " + author.date());
                System.out.println("Version: " + author.version());
            }
            
            // Get method annotations
            System.out.println("\n=== Method Annotations ===");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("\nMethod: " + method.getName());
                if (method.isAnnotationPresent(Author.class)) {
                    Author author = method.getAnnotation(Author.class);
                    System.out.println("  Author: " + author.name());
                    System.out.println("  Date: " + author.date());
                    System.out.println("  Version: " + author.version());
                }
            }
            
            // Get field annotations
            System.out.println("\n=== Field Annotations ===");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("\nField: " + field.getName());
                if (field.isAnnotationPresent(Author.class)) {
                    Author author = field.getAnnotation(Author.class);
                    System.out.println("  Author: " + author.name());
                    System.out.println("  Date: " + author.date());
                    System.out.println("  Version: " + author.version());
                }
            }
            
            // Get all annotations on class
            System.out.println("\n=== All Class Annotations ===");
            java.lang.annotation.Annotation[] annotations = clazz.getAnnotations();
            for (java.lang.annotation.Annotation annotation : annotations) {
                System.out.println("Annotation: " + annotation);
            }
            
            // Demonstrate runtime annotation processing
            processAnnotatedClass(SampleClass.class);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void processAnnotatedClass(Class<?> clazz) {
        System.out.println("\n=== Runtime Annotation Processing ===");
        
        // Process class-level annotation
        if (clazz.isAnnotationPresent(Author.class)) {
            Author author = clazz.getAnnotation(Author.class);
            System.out.println("Processing class: " + clazz.getSimpleName());
            System.out.println("Author: " + author.name() + " (v" + author.version() + ")");
            System.out.println("Created on: " + author.date());
        }
        
        // Process method annotations
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Author.class)) {
                Author author = method.getAnnotation(Author.class);
                System.out.println("Method " + method.getName() + " by " + author.name());
            }
        }
    }
}