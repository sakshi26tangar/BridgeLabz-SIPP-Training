package collectors;
import java.util.*;
import java.util.stream.*;
import java.util.List;
import java.util.Map;

class Student {
    String name;
    String grade;

    Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGrouping {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Rahul", "A"),
            new Student("Anita", "B"),
            new Student("Suresh", "A"),
            new Student("Priya", "C"),
            new Student("Vikram", "B")
        );

        Map<String, List<String>> grouped = students.stream()
            .collect(Collectors.groupingBy(
                s -> s.grade,
                Collectors.mapping(s -> s.name, Collectors.toList())
            ));

        grouped.forEach((grade, names) -> 
            System.out.println("Grade " + grade + " -> " + names));
    }
}