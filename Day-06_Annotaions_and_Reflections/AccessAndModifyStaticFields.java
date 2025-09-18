import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "default-api-key-12345";
    private static int MAX_CONNECTIONS = 10;
    private static boolean DEBUG_MODE = false;
    
    public static void displayConfig() {
        System.out.println("Current Configuration:");
        System.out.println("API_KEY: " + API_KEY);
        System.out.println("MAX_CONNECTIONS: " + MAX_CONNECTIONS);
        System.out.println("DEBUG_MODE: " + DEBUG_MODE);
    }
}

public class AccessAndModifyStaticFields {
    public static void main(String[] args) {
        try {
            System.out.println("=== Before Modification ===");
            Configuration.displayConfig();
            
            // Get the Configuration class
            Class<?> configClass = Configuration.class;
            
            // Access and modify API_KEY
            Field apiKeyField = configClass.getDeclaredField("API_KEY");
            apiKeyField.setAccessible(true);
            
            String originalApiKey = (String) apiKeyField.get(null); // null for static fields
            System.out.println("\nOriginal API_KEY: " + originalApiKey);
            
            apiKeyField.set(null, "new-secret-api-key-67890");
            
            // Access and modify MAX_CONNECTIONS
            Field maxConnectionsField = configClass.getDeclaredField("MAX_CONNECTIONS");
            maxConnectionsField.setAccessible(true);
            
            int originalMaxConnections = (int) maxConnectionsField.get(null);
            System.out.println("Original MAX_CONNECTIONS: " + originalMaxConnections);
            
            maxConnectionsField.set(null, 50);
            
            // Access and modify DEBUG_MODE
            Field debugModeField = configClass.getDeclaredField("DEBUG_MODE");
            debugModeField.setAccessible(true);
            
            boolean originalDebugMode = (boolean) debugModeField.get(null);
            System.out.println("Original DEBUG_MODE: " + originalDebugMode);
            
            debugModeField.set(null, true);
            
            System.out.println("\n=== After Modification ===");
            Configuration.displayConfig();
            
            // Demonstrate getting all static fields
            System.out.println("\n=== All Static Fields ===");
            Field[] fields = configClass.getDeclaredFields();
            for (Field field : fields) {
                if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    System.out.println("Static Field: " + field.getName() + 
                                     " = " + field.get(null) + 
                                     " (Type: " + field.getType().getSimpleName() + ")");
                }
            }
            
            // Demonstrate utility method for configuration management
            updateConfiguration("API_KEY", "updated-api-key-xyz");
            updateConfiguration("MAX_CONNECTIONS", 100);
            updateConfiguration("DEBUG_MODE", false);
            
            System.out.println("\n=== After Utility Updates ===");
            Configuration.displayConfig();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void updateConfiguration(String fieldName, Object newValue) {
        try {
            Class<?> configClass = Configuration.class;
            Field field = configClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            
            // Type checking
            Class<?> fieldType = field.getType();
            if (fieldType == String.class && newValue instanceof String) {
                field.set(null, newValue);
            } else if (fieldType == int.class && newValue instanceof Integer) {
                field.set(null, newValue);
            } else if (fieldType == boolean.class && newValue instanceof Boolean) {
                field.set(null, newValue);
            } else {
                System.out.println("Type mismatch for field " + fieldName);
            }
            
        } catch (Exception e) {
            System.out.println("Error updating configuration: " + e.getMessage());
        }
    }
}