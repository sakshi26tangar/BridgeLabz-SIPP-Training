import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

// Interface for the greeting service
interface Greeting {
    String sayHello(String name);
    String sayGoodbye(String name);
    String getGreetingMessage(String name, String timeOfDay);
}

// Real implementation of the greeting service
class RealGreeting implements Greeting {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }
    
    @Override
    public String sayGoodbye(String name) {
        return "Goodbye, " + name + "!";
    }
    
    @Override
    public String getGreetingMessage(String name, String timeOfDay) {
        return "Good " + timeOfDay + ", " + name + "!";
    }
}

// Logging proxy handler
class LoggingProxyHandler implements InvocationHandler {
    private final Object realObject;
    
    public LoggingProxyHandler(Object realObject) {
        this.realObject = realObject;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        
        // Log method entry
        System.out.println("[LOG] " + new Date() + " - Calling method: " + method.getName());
        System.out.println("[LOG] Arguments: " + formatArgs(args));
        
        try {
            // Invoke the actual method
            Object result = method.invoke(realObject, args);
            
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            
            // Log method exit
            System.out.println("[LOG] Method " + method.getName() + " completed in " + duration + "ms");
            System.out.println("[LOG] Result: " + result);
            System.out.println();
            
            return result;
            
        } catch (Exception e) {
            System.out.println("[LOG] Method " + method.getName() + " threw exception: " + e.getCause());
            throw e.getCause();
        }
    }
    
    private String formatArgs(Object[] args) {
        if (args == null || args.length == 0) {
            return "none";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(args[i]);
        }
        return sb.toString();
    }
}

// Utility class for creating proxies
class LoggingProxyFactory {
    @SuppressWarnings("unchecked")
    public static <T> T createLoggingProxy(Class<T> interfaceClass, T realObject) {
        return (T) Proxy.newProxyInstance(
            interfaceClass.getClassLoader(),
            new Class<?>[] { interfaceClass },
            new LoggingProxyHandler(realObject)
        );
    }
}

public class CustomLoggingProxy {
    public static void main(String[] args) {
        // Create real greeting service
        Greeting realGreeting = new RealGreeting();
        
        // Create logging proxy
        Greeting loggingGreeting = LoggingProxyFactory.createLoggingProxy(Greeting.class, realGreeting);
        
        System.out.println("=== Using Logging Proxy ===");
        
        // Use the proxy - all calls will be logged
        String hello1 = loggingGreeting.sayHello("Alice");
        System.out.println("Returned: " + hello1);
        
        String goodbye1 = loggingGreeting.sayGoodbye("Bob");
        System.out.println("Returned: " + goodbye1);
        
        String greeting = loggingGreeting.getGreetingMessage("Charlie", "morning");
        System.out.println("Returned: " + greeting);
        
        // Demonstrate multiple calls
        System.out.println("\n=== Multiple Calls Demo ===");
        String[] names = {"David", "Emma", "Frank"};
        
        for (String name : names) {
            loggingGreeting.sayHello(name);
        }
        
        // Demonstrate exception handling
        System.out.println("\n=== Exception Handling Demo ===");
        try {
            // Create a service that might throw exceptions
            Greeting exceptionGreeting = LoggingProxyFactory.createLoggingProxy(Greeting.class, 
                new Greeting() {
                    @Override
                    public String sayHello(String name) {
                        if (name == null || name.trim().isEmpty()) {
                            throw new IllegalArgumentException("Name cannot be null or empty");
                        }
                        return "Hello, " + name;
                    }
                    
                    @Override
                    public String sayGoodbye(String name) {
                        return "Goodbye, " + name;
                    }
                    
                    @Override
                    public String getGreetingMessage(String name, String timeOfDay) {
                        return "Good " + timeOfDay + ", " + name;
                    }
                }
            );
            
            exceptionGreeting.sayHello("Valid Name");
            exceptionGreeting.sayHello(""); // This will throw exception
            
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}