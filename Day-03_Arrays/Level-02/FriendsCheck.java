import java.util.Scanner;

public class FriendsCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter age and height of " + friends[i] + ": ");
            ages[i] = sc.nextInt();
            heights[i] = sc.nextDouble();
        }

        int minAgeIndex = 0, maxHeightIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[minAgeIndex])
                minAgeIndex = i;
            if (heights[i] > heights[maxHeightIndex])
                maxHeightIndex = i;
        }

        System.out.println("Youngest: " + friends[minAgeIndex]);
        System.out.println("Tallest: " + friends[maxHeightIndex]);
    }
}
