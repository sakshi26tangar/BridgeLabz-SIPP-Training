class Student {
    static String universityName = "GLA University";
    private static int totalStudents = 0;

    private final int rollNumber;
    private String name;
    private char grade;

    public Student(int rollNumber, String name, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    public void displayDetails() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Name: " + this.name);
            System.out.println("Roll Number: " + this.rollNumber);
            System.out.println("Grade: " + this.grade);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(201, "Eva", 'A');
        Student s2 = new Student(202, "Frank", 'B');

        s1.displayDetails();
        s2.displayDetails();
        displayTotalStudents();
    }
}
