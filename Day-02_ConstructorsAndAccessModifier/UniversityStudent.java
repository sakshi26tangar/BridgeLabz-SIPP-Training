public class UniversityStudent {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public UniversityStudent(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

class PostgraduateStudent extends UniversityStudent {
    String specialization;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    public void displayStudentInfo() {
        System.out.println("Roll: " + rollNumber + ", Name: " + name + ", Specialization: " + specialization);
    }

    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent(101, "Kavya", 8.9, "Data Science");
        pg.displayStudentInfo();
        System.out.println("CGPA: " + pg.getCGPA());
    }
}
