public class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public void showDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Evaluation: " + courseType.getEvaluationMethod());
        courseType.evaluate();
    }

    public T getCourseType() {
        return courseType;
    }
}
