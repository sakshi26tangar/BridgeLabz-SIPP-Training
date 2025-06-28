class Patient {
    static String hospitalName = "City Hospital";
    private static int totalPatients = 0;

    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }

    public void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + this.patientID);
            System.out.println("Name: " + this.name);
            System.out.println("Age: " + this.age);
            System.out.println("Ailment: " + this.ailment);
        }
    }

    public static void main(String[] args) {
        Patient p1 = new Patient(301, "Amit", 30, "Flu");
        Patient p2 = new Patient(302, "Riya", 25, "Injury");

        p1.displayDetails();
        p2.displayDetails();
        getTotalPatients();
    }
}
