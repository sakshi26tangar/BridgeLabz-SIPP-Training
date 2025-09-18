import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Custom annotations for dependency injection
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.CONSTRUCTOR})
@interface Inject {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Component {}

// Service interfaces and implementations
interface DatabaseService {
    void save(String data);
    String load(String id);
}

@Component
class RealDatabaseService implements DatabaseService {
    @Override
    public void save(String data) {
        System.out.println("Saving to database: " + data);
    }
    
    @Override
    public String load(String id) {
        return "Data from database for ID: " + id;
    }
}

interface EmailService {
    void sendEmail(String to, String subject, String body);
}

@Component
class SmtpEmailService implements EmailService {
    @Override
    public void sendEmail(String to, String subject, String body) {
        System.out.println("Sending email to " + to + ": " + subject);
    }
}

// User service that depends on other services
@Component
class UserService {
    @Inject
    private DatabaseService databaseService;
    
    @Inject
    private EmailService emailService;
    
    public void createUser(String username, String email) {
        databaseService.save("User: " + username);
        emailService.sendEmail(email, "Welcome", "Welcome to our service, " + username);
    }
    
    public String getUser(String userId) {
        return databaseService.load(userId);
    }
}

// Simple DI container
class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();
    
    public void register(Class<?> interfaceClass, Class<?> implementationClass) {
        try {
            Object instance = createInstance(implementationClass);
            instances.put(interfaceClass, instance);
            instances.put(implementationClass, instance);
        } catch (Exception e) {
            throw new RuntimeException("Failed to register " + implementationClass.getSimpleName(), e);
        }
    }
    
    public <T> T getInstance(Class<T> clazz) {
        Object instance = instances.get(clazz);
        if (instance == null) {
            instance = createInstance(clazz);
            instances.put(clazz, instance);
        }
        return clazz.cast(instance);
    }
    
    private Object createInstance(Class<?> clazz) {
        try {
            // Look for @Inject annotated constructor
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                if (constructor.isAnnotationPresent(Inject.class)) {
                    return createInstanceWithConstructor(constructor);
                }
            }
            
            // Use default constructor
            Object instance = clazz.getDeclaredConstructor().newInstance();
            
            // Inject dependencies into fields
            injectFields(instance);
            
            return instance;
            
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance of " + clazz.getSimpleName(), e);
        }
    }
    
    private Object createInstanceWithConstructor(Constructor<?> constructor) {
        try {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Object[] parameters = new Object[parameterTypes.length];
            
            for (int i = 0; i < parameterTypes.length; i++) {
                parameters[i] = getInstance(parameterTypes[i]);
            }
            
            return constructor.newInstance(parameters);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance with constructor", e);
        }
    }
    
    private void injectFields(Object instance) {
        try {
            Field[] fields = instance.getClass().getDeclaredFields();
            
            for (Field field : fields) {
                if (field.isAnnotationPresent(Inject.class)) {
                    Object dependency = getInstance(field.getType());
                    field.setAccessible(true);
                    field.set(instance, dependency);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to inject dependencies", e);
        }
    }
}

public class DependencyInjectionContainer {
    public static void main(String[] args) {
        // Create DI container
        DIContainer container = new DIContainer();
        
        // Register services
        container.register(DatabaseService.class, RealDatabaseService.class);
        container.register(EmailService.class, SmtpEmailService.class);
        
        // Get UserService with dependencies injected
        UserService userService = container.getInstance(UserService.class);
        
        System.out.println("=== Dependency Injection Demo ===");
        
        // Use the service
        userService.createUser("alice", "alice@example.com");
        userService.createUser("bob", "bob@example.com");
        
        String userData = userService.getUser("123");
        System.out.println("Retrieved: " + userData);
        
        // Demonstrate multiple instances
        UserService userService2 = container.getInstance(UserService.class);
        System.out.println("Same instance? " + (userService == userService2));
        
        // Show all registered instances
        System.out.println("\n=== Registered Instances ===");
        System.out.println("DatabaseService: " + container.getInstance(DatabaseService.class).getClass().getSimpleName());
        System.out.println("EmailService: " + container.getInstance(EmailService.class).getClass().getSimpleName());
    }
}