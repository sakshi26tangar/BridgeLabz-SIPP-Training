class Employee {
    static String companyName = "Tech Corp";
    private static int totalEmployees = 0;

    private final int id;
    private String name, designation;

    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayDetails() {
        if (this instanceof Employee) {
            System.out.println("Company: " + companyName);
            System.out.println("Name: " + this.name);
            System.out.println("ID: " + this.id);
            System.out.println("Designation: " + this.designation);
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Charlie", "Developer");
        Employee e2 = new Employee(102, "Diana", "Manager");

        e1.displayDetails();
        e2.displayDetails();
        displayTotalEmployees();
    }
}
