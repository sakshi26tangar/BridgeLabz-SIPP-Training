package Marker_Interface;

class Prototype implements Cloneable {
    private String name;

    public Prototype(String name) {
        this.name = name;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // Shallow copy
    }

    public String toString() {
        return "Prototype{name='" + name + "'}";
    }
}

public class PrototypeCloning {
    public static void main(String[] args) {
        try {
            Prototype original = new Prototype("Model-A");
            Prototype copy = (Prototype) original.clone();

            System.out.println("Original: " + original);
            System.out.println("Cloned: " + copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

