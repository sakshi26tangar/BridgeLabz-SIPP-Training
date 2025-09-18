import java.lang.reflect.Field;

class Person {
    private String name = "Default Name";
    private int age = 25;
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class AccessPrivateField {
    public static void main(String[] args) {
        try {
            // Create Person instance
            Person person = new Person();
            System.out.println("Before: " + person);
            
            // Get the Person class
            Class<?> personClass = Person.class;
            
            // Access private field 'age'
            Field ageField = personClass.getDeclaredField("age");
            ageField.setAccessible(true); // Make private field accessible
            
            // Get current value
            int currentAge = (int) ageField.get(person);
            System.out.println("Current age: " + currentAge);
            
            // Modify the value
            ageField.set(person, 30);
            
            // Access private field 'name'
            Field nameField = personClass.getDeclaredField("name");
            nameField.setAccessible(true);
            
            // Get and modify name
            String currentName = (String) nameField.get(person);
            System.out.println("Current name: " + currentName);
            nameField.set(person, "John Doe");
            
            System.out.println("After: " + person);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}