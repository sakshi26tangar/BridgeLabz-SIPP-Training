import java.util.*;

public class BinaryNumbers {
    public static void main(String[] args) {
        int n = 5;
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        System.out.println("First " + n + " binary numbers:");
        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            System.out.print(current + " ");
            queue.add(current + "0");
            queue.add(current + "1");
        }
    }
}
