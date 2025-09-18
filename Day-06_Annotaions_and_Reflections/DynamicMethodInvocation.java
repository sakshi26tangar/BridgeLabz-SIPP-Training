import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
    
    public int power(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MathOperations mathOps = new MathOperations();
        
        System.out.println("=== Dynamic Method Invocation Demo ===");
        System.out.println("Available methods: add, subtract, multiply, divide, power");
        
        while (true) {
            System.out.print("\nEnter method name (or 'exit' to quit): ");
            String methodName = scanner.nextLine();
            
            if (methodName.equalsIgnoreCase("exit")) {
                break;
            }
            
            try {
                // Get all methods from MathOperations class
                Method[] methods = MathOperations.class.getDeclaredMethods();
                boolean methodFound = false;
                
                for (Method method : methods) {
                    if (method.getName().equalsIgnoreCase(methodName)) {
                        methodFound = true;
                        invokeMethod(mathOps, method, scanner);
                        break;
                    }
                }
                
                if (!methodFound) {
                    System.out.println("Method '" + methodName + "' not found. Available methods: add, subtract, multiply, divide, power");
                }
                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        scanner.close();
        System.out.println("Thank you for using the calculator!");
    }
    
    public static void invokeMethod(MathOperations mathOps, Method method, Scanner scanner) {
        try {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Object[] parameters = new Object[parameterTypes.length];
            
            System.out.println("Method: " + method.getName() + " with " + parameterTypes.length + " parameters");
            
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.print("Enter parameter " + (i + 1) + " (" + parameterTypes[i].getSimpleName() + "): ");
                String input = scanner.nextLine();
                
                if (parameterTypes[i] == int.class) {
                    parameters[i] = Integer.parseInt(input);
                } else if (parameterTypes[i] == double.class) {
                    parameters[i] = Double.parseDouble(input);
                } else {
                    parameters[i] = input;
                }
            }
            
            Object result = method.invoke(mathOps, parameters);
            System.out.println("Result: " + result);
            
        } catch (Exception e) {
            System.out.println("Error invoking method: " + e.getMessage());
        }
    }
    
    // Alternative approach using direct method lookup
    public static Object callMethod(Object obj, String methodName, Object... args) {
        try {
            Class<?>[] parameterTypes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                parameterTypes[i] = args[i].getClass();
                // Handle primitive types
                if (args[i] instanceof Integer) parameterTypes[i] = int.class;
                else if (args[i] instanceof Double) parameterTypes[i] = double.class;
            }
            
            Method method = obj.getClass().getMethod(methodName, parameterTypes);
            return method.invoke(obj, args);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}