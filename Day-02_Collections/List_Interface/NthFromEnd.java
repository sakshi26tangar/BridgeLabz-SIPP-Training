import java.util.*;

public class NthFromEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter LinkedList elements (space-separated):");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(sc.nextLine().split(" ")));

        System.out.print("Enter N: ");
        int n = sc.nextInt();

        Iterator<String> fast = list.iterator();
        Iterator<String> slow = list.iterator();

        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) {
                System.out.println("List is shorter than N.");
                return;
            }
            fast.next();
        }

        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        System.out.println("Nth Element from End: " + slow.next());
    }
}
