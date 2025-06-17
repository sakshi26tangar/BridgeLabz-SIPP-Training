import java.util.*;
public class Multiplication6To9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = {6, 7, 8, 9};
        System.out.println("enter the no.: ");
        int n = sc.nextInt();
        for (int i = numbers[0]; i < numbers[numbers.length]; i++) {
            System.out.println(n + " * " + i + " = " + n * i);
        }
    }
}
