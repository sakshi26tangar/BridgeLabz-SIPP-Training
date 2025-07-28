import java.util.*;
import java.util.Scanner;
public class ReverseList {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter integers (space-separated):");
            List<Integer> arrayList = new ArrayList<>();
            for (String s : sc.nextLine().split(" ")) {
                arrayList.add(Integer.parseInt(s));
            }

            for (int i = 0, j = arrayList.size() - 1; i < j; i++, j--) {
                int temp = arrayList.get(i);
                arrayList.set(i, arrayList.get(j));
                arrayList.set(j, temp);
            }
            System.out.println("Reversed ArrayList: " + arrayList);

            LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
            for (int i = 0, j = linkedList.size() - 1; i < j; i++, j--) {
                int temp = linkedList.get(i);
                linkedList.set(i, linkedList.get(j));
                linkedList.set(j, temp);
            }
            System.out.println("Reversed LinkedList: " + linkedList);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
