import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
    
    private String greet(String name) {
        return "Hello, " + name + "!";
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) {
        try {
            // Create Calculator instance
            Calculator calculator = new Calculator();
            
            // Get the Calculator class
            Class<?> calculatorClass = Calculator.class;
            
            // Get the private multiply method
            Method multiplyMethod = calculatorClass.getDeclaredMethod("multiply", int.class, int.class);
            multiplyMethod.setAccessible(true);
            
            // Invoke the private method
            int result = (int) multiplyMethod.invoke(calculator, 5, 3);
            System.out.println("5 * 3 = " + result);
            
            // Get the private greet method
            Method greetMethod = calculatorClass.getDeclaredMethod("greet", String.class);
            greetMethod.setAccessible(true);
            
            // Invoke the private method
            String greeting = (String) greetMethod.invoke(calculator, "Alice");
            System.out.println("Greeting: " + greeting);
            
            // Demonstrate dynamic method invocation
            System.out.println("\nDynamic Method Invocation:");
            invokeMethod(calculator, "multiply", 10, 4);
            invokeMethod(calculator, "greet", "Bob");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void invokeMethod(Object obj, String methodName, Object... args) {
        try {
            Class<?> clazz = obj.getClass();
            
            // Find the method with matching parameter types
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.getName().equals(methodName) && 
                    method.getParameterCount() == args.length) {
                    method.setAccessible(true);
                    Object result = method.invoke(obj, args);
                    System.out.println(methodName + " result: " + result);
                    return;
                }
            }
            
            System.out.println("Method not found: " + methodName);
            
        } catch (Exception e) {
            System.out.println("Error invoking method: " + e.getMessage());
        }
    }
}