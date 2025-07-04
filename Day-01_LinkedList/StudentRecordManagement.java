import java.util.Scanner;

class Student {
    int roll;
    String name;
    Student next;
    Student(int r, String n) {
        roll = r;
        name = n;
        next = null;
    }
}

public class StudentRecordManagement {
    Student head;

    void add(int roll, String name) {
        Student s = new Student(roll, name);
        if (head == null) head = s;
        else {
            Student temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = s;
        }
    }

    void delete(int roll) {
        if (head == null) return;
        if (head.roll == roll) { head = head.next; return; }
        Student temp = head;
        while (temp.next != null && temp.next.roll != roll)
            temp = temp.next;
        if (temp.next != null) temp.next = temp.next.next;
    }

    void search(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Found: " + temp.roll + " " + temp.name);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Not found");
    }

    void update(int roll, String newName) {
        Student temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                temp.name = newName;
                System.out.println("Updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Not found");
    }

    void display() {
        Student temp = head;
        while (temp != null) {
            System.out.println(temp.roll + " " + temp.name);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        StudentRecordManagement list = new StudentRecordManagement();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1:Add 2:Delete 3:Search 4:Update 5:Display 0:Exit");
            int ch = scanner.nextInt();
            if (ch == 0) break;
            int roll;
            String name;
            switch (ch) {
                case 1: roll = scanner.nextInt(); name = scanner.next(); list.add(roll, name); break;
                case 2: roll = scanner.nextInt(); list.delete(roll); break;
                case 3: roll = scanner.nextInt(); list.search(roll); break;
                case 4: roll = scanner.nextInt(); name = scanner.next(); list.update(roll, name); break;
                case 5: list.display(); break;
            }
        }
    }
}
