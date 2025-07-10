import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecordList {
    private Student head = null;

    // Add at beginning
    public void addAtBeginning(int rollNo, String name, int age, char grade) {
        Student newStudent = new Student(rollNo, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Add at end
    public void addAtEnd(int rollNo, String name, int age, char grade) {
        Student newStudent = new Student(rollNo, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newStudent;
    }

    // Add at specific position (0-based index)
    public void addAtPosition(int index, int rollNo, String name, int age, char grade) {
        if (index == 0) {
            addAtBeginning(rollNo, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNo, name, age, grade);
        Student temp = head;
        for (int i = 0; i < index - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }

        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    // Delete by roll number
    public void deleteByRollNumber(int rollNo) {
        if (head == null) return;

        if (head.rollNo == rollNo) {
            head = head.next;
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo)
            temp = temp.next;

        if (temp.next == null) {
            System.out.println("Student not found.");
            return;
        }

        temp.next = temp.next.next;
    }

    // Search student
    public void searchByRollNumber(int rollNo) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Found: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Update grade
    public void updateGrade(int rollNo, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    // Display all students
    public void display() {
        if (head == null) {
            System.out.println("No records found.");
            return;
        }

        Student temp = head;
        System.out.println("Student Records:");
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRecordList list = new StudentRecordList();

        while (true) {
            System.out.println("\n--- Student Record Menu ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Roll No");
            System.out.println("5. Search by Roll No");
            System.out.println("6. Update Grade");
            System.out.println("7. Display All");
            System.out.println("8. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            if (choice == 8) break;

            switch (choice) {
                case 1, 2, 3 -> {
                    System.out.print("Enter Roll No, Name, Age, Grade: ");
                    int roll = sc.nextInt();
                    String name = sc.next();
                    int age = sc.nextInt();
                    char grade = sc.next().charAt(0);
                    if (choice == 1) list.addAtBeginning(roll, name, age, grade);
                    else if (choice == 2) list.addAtEnd(roll, name, age, grade);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        list.addAtPosition(pos, roll, name, age, grade);
                    }
                }
                case 4 -> {
                    System.out.print("Enter Roll No to delete: ");
                    int roll = sc.nextInt();
                    list.deleteByRollNumber(roll);
                }
                case 5 -> {
                    System.out.print("Enter Roll No to search: ");
                    int roll = sc.nextInt();
                    list.searchByRollNumber(roll);
                }
                case 6 -> {
                    System.out.print("Enter Roll No and New Grade: ");
                    int roll = sc.nextInt();
                    char grade = sc.next().charAt(0);
                    list.updateGrade(roll, grade);
                }
                case 7 -> list.display();
                default -> System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
