import java.util.Scanner;

public class HandshakeCalculator {

    
    public static int calculateHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        
        if (numberOfStudents < 0) {
            System.out.println("Invalid number of students. Please enter a positive number.");
        } else {
            
            int handshakes = calculateHandshakes(numberOfStudents);
            System.out.println("The maximum number of handshakes possible is: " + handshakes);
        }

        scanner.close();
    }
}
