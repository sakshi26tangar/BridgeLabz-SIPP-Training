import java.util.Scanner;

public class NumAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];  

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

       
        for (int i = 0 ; i < arr.length; i++) {
            if (arr[i] > 0) {
                if (arr[i] % 2 == 0) {
                    System.out.println("The number " + arr[i] + " is positive and even.");
                } else {
                    System.out.println("The number " + arr[i] + " is positive and odd.");
                }
            } else if (arr[i] < 0) {
                System.out.println("The number " + arr[i] + " is negative.");
            } else {
                System.out.println("The number is zero.");
            }
        }

        // Comparing first and last elements
        int f = arr[0];
        int l = arr[arr.length - 1];
        System.out.println("\nComparison of first and last elements:");
        if (f == l) {
            System.out.println("The first and last elements are equal.");
        } else if (f > l) {
            System.out.println("The first element is greater than the last element.");
        } else {
            System.out.println("The first element is less than the last element.");
        }

        sc.close();
    }
}