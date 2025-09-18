import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
// Sample service classes to demonstrate timing
class DataProcessor {
    public void processSmallData() {
        try {
            Thread.sleep(100); // Simulate 100ms processing
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public void processLargeData() {
        try {
            Thread.sleep(500); // Simulate 500ms processing
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public int calculateSum(int... numbers) {
        return Arrays.stream(numbers).sum();
    }
    
    public String processString(String input) {
        return input.toUpperCase().replaceAll("\\s+", "");
    }
}

class MathOperations {
    public long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
    
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    public List<Integer> generateFibonacci(int count) {
        return Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34).subList(0, Math.min(count, 10));
    }
}

// Timing utility class
class MethodTimer {
    
    public static long timeMethod(Object target, String methodName, Object... args) {
        try {
            Method method = findMethod(target.getClass(), methodName, args);
            if (method == null) {
                System.out.println("Method not found: " + methodName);
                return -1;
            }
            
            long startTime = System.nanoTime();
            method.invoke(target, args);
            long endTime = System.nanoTime();
            
            return endTime - startTime;
            
        } catch (Exception e) {
            System.out.println("Error timing method: " + e.getMessage());
            return -1;
        }
    }
    
    public static MethodTimingResult timeMethodWithResult(Object target, String methodName, Object... args) {
        try {
            Method method = findMethod(target.getClass(), methodName, args);
            if (method == null) {
                System.out.println("Method not found: " + methodName);
                return new MethodTimingResult(methodName, -1, null);
            }
            
            long startTime = System.nanoTime();
            Object result = method.invoke(target, args);
            long endTime = System.nanoTime();
            
            long duration = endTime - startTime;
            return new MethodTimingResult(methodName, duration, result);
            
        } catch (Exception e) {
            System.out.println("Error timing method: " + e.getMessage());
            return new MethodTimingResult(methodName, -1, null);
        }
    }
    
    public static void timeAllMethods(Object target) {
        System.out.println("=== Timing all methods in " + target.getClass().getSimpleName() + " ===");
        
        Method[] methods = target.getClass().getDeclaredMethods();
        
        for (Method method : methods) {
            if (java.lang.reflect.Modifier.isPublic(method.getModifiers())) {
                timeAndReportMethod(target, method);
            }
        }
    }
    
    private static void timeAndReportMethod(Object target, Method method) {
        try {
            String methodName = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            
            System.out.println("\nTiming method: " + methodName);
            
            // Generate appropriate test arguments based on parameter types
            Object[] testArgs = generateTestArguments(parameterTypes, method.isVarArgs());
            
            long duration = timeMethod(target, methodName, testArgs);
            
            if (duration >= 0) {
                System.out.println("Duration: " + formatDuration(duration));
            }
            
        } catch (Exception e) {
            System.out.println("Could not time method " + method.getName() + ": " + e.getMessage());
        }
    }
    
    private static Class<?>[] getParameterTypes(Object[] args) {
        if (args == null || args.length == 0) {
            return new Class[0];
        }
        
        Class<?>[] types = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] == null) {
                types[i] = Object.class;
                continue;
            }
            
            Class<?> argClass = args[i].getClass();
            // Handle primitive type boxing and arrays
            if (args[i] instanceof Integer) types[i] = int.class;
            else if (args[i] instanceof Long) types[i] = long.class;
            else if (args[i] instanceof Double) types[i] = double.class;
            else if (args[i] instanceof Boolean) types[i] = boolean.class;
            else if (args[i] instanceof int[]) types[i] = int[].class;
            else types[i] = argClass;
        }
        return types;
    }
    
    private static Object[] generateTestArguments(Class<?>[] parameterTypes, boolean isVarArgs) {
        Object[] args = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> type = parameterTypes[i];
            if (type == int.class) args[i] = 42;
            else if (type == long.class) args[i] = 100L;
            else if (type == String.class) args[i] = "test";
            else if (type == int[].class) args[i] = new int[]{1, 2, 3, 4, 5};
            else if (type == List.class) args[i] = Arrays.asList(1, 2, 3);
            else if (isVarArgs && i == parameterTypes.length - 1) {
                Class<?> componentType = type.getComponentType();
                if (componentType == int.class) {
                    args[i] = new int[]{1, 2, 3, 4, 5};
                } else if (componentType == String.class) {
                    args[i] = new String[]{"vararg1", "vararg2"};
                } else {
                    args[i] = null;
                }
            } else {
                args[i] = null;
            }
        }
        return args;
    }
    
    private static Method findMethod(Class<?> clazz, String methodName, Object... args) {
        Method[] methods = clazz.getMethods();
        
        for (Method method : methods) {
            if (!method.getName().equals(methodName)) continue;
            
            Class<?>[] parameterTypes = method.getParameterTypes();
            
            // Handle no-args methods
            if (args.length == 0 && parameterTypes.length == 0) {
                return method;
            }
            
            // Check if parameters match
            if (isParameterMatch(parameterTypes, args)) {
                return method;
            }
        }
        
        return null;
    }
    
    private static boolean isParameterMatch(Class<?>[] parameterTypes, Object[] args) {
        if (parameterTypes.length == 0 && args.length == 0) return true;
        
        // Handle varargs
        if (parameterTypes.length > 0 && parameterTypes[parameterTypes.length - 1].isArray()) {
            return handleVarargsMatch(parameterTypes, args);
        }
        
        // Regular parameter matching
        if (parameterTypes.length != args.length) return false;
        
        for (int i = 0; i < parameterTypes.length; i++) {
            if (!isTypeCompatible(parameterTypes[i], args[i])) {
                return false;
            }
        }
        
        return true;
    }
    
    private static boolean handleVarargsMatch(Class<?>[] parameterTypes, Object[] args) {
        int requiredParams = parameterTypes.length - 1;
        
        // Special case: if we have exactly one argument and it's an array that matches the varargs type
        if (args.length == 1 && args[0] != null && args[0].getClass().isArray() && 
            parameterTypes[parameterTypes.length - 1].isAssignableFrom(args[0].getClass())) {
            return true;
        }
        
        if (args.length < requiredParams) return false;
        
        // Check required parameters
        for (int i = 0; i < requiredParams; i++) {
            if (!isTypeCompatible(parameterTypes[i], args[i])) {
                return false;
            }
        }
        
        // Check varargs part
        Class<?> varargType = parameterTypes[parameterTypes.length - 1].getComponentType();
        for (int i = requiredParams; i < args.length; i++) {
            if (!isTypeCompatible(varargType, args[i])) {
                return false;
            }
        }
        
        return true;
    }
    
    private static boolean isTypeCompatible(Class<?> parameterType, Object arg) {
        if (arg == null) return !parameterType.isPrimitive();
        
        Class<?> argType = arg.getClass();
        
        // Handle primitive types
        if (parameterType.isPrimitive()) {
            return (parameterType == int.class && arg instanceof Integer) ||
                   (parameterType == long.class && arg instanceof Long) ||
                   (parameterType == double.class && arg instanceof Double) ||
                   (parameterType == boolean.class && arg instanceof Boolean);
        }
        
        // Handle arrays
        if (parameterType.isArray()) {
            return parameterType.isAssignableFrom(argType);
        }
        
        return parameterType.isAssignableFrom(argType);
    }
    
    public static String formatDuration(long nanoseconds) {
        if (nanoseconds < 1000) {
            return nanoseconds + " ns";
        } else if (nanoseconds < 1_000_000) {
            return (nanoseconds / 1000) + " μs";
        } else if (nanoseconds < 1_000_000_000) {
            return (nanoseconds / 1_000_000) + " ms";
        } else {
            return (nanoseconds / 1_000_000_000) + " s";
        }
    }
}

// Result class for method timing
class MethodTimingResult {
    private final String methodName;
    private final long durationNanos;
    private final Object result;
    
    public MethodTimingResult(String methodName, long durationNanos, Object result) {
        this.methodName = methodName;
        this.durationNanos = durationNanos;
        this.result = result;
    }
    
    public String getMethodName() { return methodName; }
    public long getDurationNanos() { return durationNanos; }
    public Object getResult() { return result; }
    
    @Override
    public String toString() {
        return "Method: " + methodName + ", Duration: " + 
               MethodTimer.formatDuration(durationNanos) +
               ", Result: " + result;
    }
}

public class MethodExecutionTiming {
    public static void main(String[] args) {
        // Test with DataProcessor
        System.out.println("=== DataProcessor Timing ===");
        DataProcessor processor = new DataProcessor();
        
        long duration1 = MethodTimer.timeMethod(processor, "processSmallData");
        System.out.println("processSmallData took: " + MethodTimer.formatDuration(duration1));
        
        long duration2 = MethodTimer.timeMethod(processor, "processLargeData");
        System.out.println("processLargeData took: " + MethodTimer.formatDuration(duration2));
        
        MethodTimingResult result1 = MethodTimer.timeMethodWithResult(processor, "calculateSum", new int[]{1, 2, 3, 4, 5});
        System.out.println("calculateSum: " + result1);
        
        MethodTimingResult result2 = MethodTimer.timeMethodWithResult(processor, "processString", "Hello World  ");
        System.out.println("processString: " + result2);
        
        // Test with MathOperations
        System.out.println("\n=== MathOperations Timing ===");
        MathOperations math = new MathOperations();
        
        MethodTimingResult factorialResult = MethodTimer.timeMethodWithResult(math, "factorial", 5);
        System.out.println("factorial: " + factorialResult);
        
        MethodTimingResult primeResult = MethodTimer.timeMethodWithResult(math, "isPrime", 17);
        System.out.println("isPrime: " + primeResult);
        
        MethodTimingResult fibResult = MethodTimer.timeMethodWithResult(math, "generateFibonacci", 5);
        System.out.println("generateFibonacci: " + fibResult);
        
        // Time all methods in a class
        System.out.println("\n=== Timing All Methods ===");
        MethodTimer.timeAllMethods(new DataProcessor());
        MethodTimer.timeAllMethods(new MathOperations());
    }
}