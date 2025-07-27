import java.util.*;

public class Main {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType c : courses) {
            System.out.println("Evaluation: " + c.getEvaluationMethod());
            c.evaluate();
            System.out.println("---");
        }
    }

    public static void main(String[] args) {
        Course<ExamCourse> java = new Course<>("Java Programming", new ExamCourse());
        Course<AssignmentCourse> dsa = new Course<>("Data Structures", new AssignmentCourse());
        Course<ResearchCourse> ai = new Course<>("AI Research", new ResearchCourse());

        java.showDetails();
        System.out.println();
        dsa.showDetails();
        System.out.println();
        ai.showDetails();

        List<CourseType> courseList = new ArrayList<>();
        courseList.add(new ExamCourse());
        courseList.add(new AssignmentCourse());
        courseList.add(new ResearchCourse());

        System.out.println("\n--- Display All Course Evaluations ---");
        displayCourses(courseList);
    }
}
