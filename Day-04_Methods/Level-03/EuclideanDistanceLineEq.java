public class EuclideanDistanceLineEq {
    public static void main(String[] args) {
        int x1 = 2, y1 = 3, x2 = 5, y2 = 7;
        double dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double m = (double)(y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        System.out.printf("Distance: %.2f%n", dist);
        System.out.printf("Line: y = %.2fx + %.2f%n", m, b);
    }
}
