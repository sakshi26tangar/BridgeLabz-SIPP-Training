public class ShortestTallestMeanHeight {
    public static void main(String[] args) {
        int[] heights = new int[11];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + (int)(Math.random() * 101);
        }
        int sum = 0, shortest = heights[0], tallest = heights[0];
        for (int h : heights) {
            sum += h;
            if (h < shortest) shortest = h;
            if (h > tallest) tallest = h;
        }
        double mean = sum / (double)heights.length;
        System.out.println("Heights array:");
        for (int h : heights) System.out.print(h + " ");
        System.out.println("\nShortest: " + shortest + " cm");
        System.out.println("Tallest: " + tallest + " cm");
        System.out.printf("Mean: %.2f cm%n", mean);
    }
}
