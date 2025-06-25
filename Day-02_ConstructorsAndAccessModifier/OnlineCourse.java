public class OnlineCourse {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "SkillForge";

    public OnlineCourse(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration +
                " months, Fee: ₹" + fee + ", Institute: " + instituteName);
    }

    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {
        OnlineCourse c1 = new OnlineCourse("Java", 3, 18000);
        c1.displayCourseDetails();
        OnlineCourse.updateInstituteName("TechAcademy");
        OnlineCourse c2 = new OnlineCourse("Python", 2, 15000);
        c2.displayCourseDetails();
    }
}

