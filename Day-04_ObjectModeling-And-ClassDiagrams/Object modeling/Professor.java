import java.util.*;

class Professor {
    String name;

    Professor(String name) {
        this.name = name;
    }

    void assignCourse(CourseU c) {
        c.professor = this;
        System.out.println(name + " assigned to " + c.name);
    }
}

class StudentU {
    String name;
    List<CourseU> enrolledCourses = new ArrayList<>();

    StudentU(String name) {
        this.name = name;
    }

    void enrollCourse(CourseU c) {
        enrolledCourses.add(c);
        c.students.add(this);
    }
}

class CourseU {
    String name;
    Professor professor;
    List<StudentU> students = new ArrayList<>();

    CourseU(String name) {
        this.name = name;
    }
}
