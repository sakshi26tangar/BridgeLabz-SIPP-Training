import java.util.Scanner;
public class SpringSeason {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int day = sc.nextInt();

        boolean isSpring = (month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20);
        System.out.println(isSpring ? "Its a Spring Season" : "Not a Spring Season");
    }
}
