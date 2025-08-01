import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            List<Employee> employees = new ArrayList<>();
            System.out.print("Enter number of employees: ");
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Department: ");
                String dept = sc.nextLine();
                System.out.print("Salary: ");
                double salary = sc.nextDouble();
                employees.add(new Employee(id, name, dept, salary));
            }
            String filename = "employees.ser";
            EmployeeSerializer.saveEmployees(employees, filename);
            List<Employee> loaded = EmployeeSerializer.loadEmployees(filename);
            System.out.println("Saved Employees:");
            for (Employee e : loaded) {
                System.out.println(e);
            }
        }
    }
}