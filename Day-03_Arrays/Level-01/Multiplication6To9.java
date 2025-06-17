import java.util.*;
public class Multiplication6To9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = {6, 7, 8, 9};
        System.out.println("enter the no.: ");
        int n = sc.nextInt();
        //int initial = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            int result = n * numbers[i];
            System.out.println(n + " * " + numbers[i] + " = " + result);
            
        }

    }
}
