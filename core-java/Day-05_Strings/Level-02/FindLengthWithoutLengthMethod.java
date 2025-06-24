import java.util.Scanner;

public class FindLengthWithoutLengthMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int count = 0;

        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {}

        System.out.println("Length using logic: " + count);
        System.out.println("Length using length(): " + str.length());
    }
}
