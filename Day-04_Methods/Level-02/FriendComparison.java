import java.util.*;

public class FriendComparison {
    public static int findYoungest(int[] ages) {
        int min = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[min]) min = i;
        }
        return min;
    }

    public static int findTallest(double[] heights) {
        int max = 0;
        for (int i = 1; i < 3; i++) {
            if (heights[i] > heights[max]) max = i;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[3];
        double[] heights = new double[3];
        for (int i = 0; i < 3; i++) {
            ages[i] = sc.nextInt();
            heights[i] = sc.nextDouble();
        }
        int youngest = findYoungest(ages);
        int tallest = findTallest(heights);
        System.out.println("Youngest: " + (youngest + 1));
        System.out.println("Tallest: " + (tallest + 1));
    }
}
