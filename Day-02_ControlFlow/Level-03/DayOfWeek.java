public class DayOfWeek {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        if (m < 3) {
            m += 12;
            y--;
        }

        int k = y % 100;
        int j = y / 100;
        int day = (d + 13*(m + 1)/5 + k + k/4 + j/4 + 5*j) % 7;

        // Adjusting: 0 = Saturday in Zeller's, we want 0 = Sunday
        int correctDay = (day + 6) % 7;
        System.out.println("Day of the week (0=Sun, ..., 6=Sat): " + correctDay);
    }
}
