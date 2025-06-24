public class CalendarDisplay {
    public static void main(String[] args) {
        int month = 7, year = 2005;
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) days[1] = 29;
        int d = 1;
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (d + x + 31 * m0 / 12) % 7;
        System.out.println("   " + months[month - 1] + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");
        for (int i = 0; i < d0; i++) System.out.print("   ");
        for (int i = 1; i <= days[month - 1]; i++) {
            System.out.printf("%2d ", i);
            if (((i + d0) % 7 == 0) || (i == days[month - 1])) System.out.println();
        }
    }
}
