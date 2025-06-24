public class CollinearPointsCheck {
    public static void main(String[] args) {
        int x1 = 2, y1 = 4, x2 = 4, y2 = 6, x3 = 6, y3 = 8;
        boolean slopeCheck = (y2 - y1)*(x3 - x2) == (y3 - y2)*(x2 - x1);
        double area = 0.5 * (x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2));
        boolean areaCheck = area == 0;
        System.out.println("Slope Collinear? " + slopeCheck);
        System.out.println("Area Collinear? " + areaCheck);
    }
}
