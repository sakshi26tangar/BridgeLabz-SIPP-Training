import java.util.PriorityQueue;


class Patient implements Comparable<Patient> {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity); // Higher severity first
    }
}

public class HospitalTriage {
public static void main(String[] args) {
    PriorityQueue<Patient> queue = new PriorityQueue<>();
    queue.add(new Patient("John", 3));
    queue.add(new Patient("Alice", 5));
    queue.add(new Patient("Bob", 2));

    System.out.println("Treatment Order:");
    while (!queue.isEmpty()) {
        System.out.println(queue.remove().name);
    }
}
}