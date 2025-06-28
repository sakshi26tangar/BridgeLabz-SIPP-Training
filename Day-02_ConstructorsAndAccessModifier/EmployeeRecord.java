public class EmployeeRecord {
    public int employeeID;
    protected String department;
    private double salary;

    public EmployeeRecord(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void updateSalary(double newSalary) {
        this.salary = newSalary;
    }

    public double getSalary() {
        return salary;
    }
}

class ManagerRecord extends EmployeeRecord {
    public ManagerRecord(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeID + ", Department: " + department);
    }

    public static void main(String[] args) {
        ManagerRecord manager = new ManagerRecord(1001, "Operations", 90000);
        manager.displayEmployeeInfo();
        System.out.println("Current Salary: ₹" + manager.getSalary());
    }
}
