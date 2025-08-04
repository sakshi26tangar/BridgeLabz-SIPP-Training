import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {
        String fileName = "students.dat";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101);
            dos.writeUTF("Anjali");
            dos.writeDouble(8.2);

            dos.writeInt(102);
            dos.writeUTF("Rahul");
            dos.writeDouble(7.9);

            dos.writeInt(103);
            dos.writeUTF("Meera");
            dos.writeDouble(9.1);
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}
