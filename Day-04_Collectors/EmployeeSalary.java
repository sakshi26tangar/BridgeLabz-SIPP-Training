package collectors;
import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    String department;
    double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

public class EmployeeSalary {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Amit", "IT", 60000),
            new Employee("Ravi", "HR", 45000),
            new Employee("Neha", "IT", 70000),
            new Employee("Sonal", "Finance", 55000),
            new Employee("Raj", "HR", 50000)
        );

        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));

        avgSalaryByDept.forEach((dept, avg) -> 
            System.out.println(dept + " -> " + avg));
    }
}