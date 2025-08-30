import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private String grade;

    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
}

public class StudentResultGrouping {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", "A"),
            new Student("Bob", "B"),
            new Student("Charlie", "A"),
            new Student("David", "C"),
            new Student("Eve", "B"),
            new Student("Frank", "A")
        );

        Map<String, List<String>> groupedByGrade = students.stream()
            .collect(Collectors.groupingBy(
                Student::getGrade, 
                Collectors.mapping(Student::getName, Collectors.toList())
            ));

        groupedByGrade.forEach((grade, names) -> {
            System.out.println("Grade " + grade + " -> " + names);
        });
    }
}
