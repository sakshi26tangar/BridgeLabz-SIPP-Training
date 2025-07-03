import java.util.*;

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private List<String> records = new ArrayList<>();

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID : " + patientId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Total Bill : ₹" + calculateBill());
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getRecords() {
        return records;
    }
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;

    public InPatient(String id, String name, int age, int daysAdmitted, double dailyRate) {
        super(id, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    public double calculateBill() {
        return daysAdmitted * dailyRate + 1000;
    }

    public void addRecord(String record) {
        getRecords().add("InPatient Note: " + record);
    }

    public List<String> viewRecords() {
        return getRecords();
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;

    public OutPatient(String id, String name, int age, double consultationFee) {
        super(id, name, age);
        this.consultationFee = consultationFee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        getRecords().add("OutPatient Note: " + record);
    }

    public List<String> viewRecords() {
        return getRecords();
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient p1 = new InPatient("P101", "Rahul", 45, 4, 1500);
        OutPatient p2 = new OutPatient("P102", "Sneha", 30, 500);

        p1.addRecord("Admitted with high fever.");
        p1.addRecord("Responding to medication.");

        p2.addRecord("Routine check-up completed.");

        patients.add(p1);
        patients.add(p2);

        System.out.println("=== Patient Billing Summary ===");

        for (Patient p : patients) {
            System.out.println("\n---------------------------");
            p.getPatientDetails();

            if (p instanceof MedicalRecord) {
                List<String> records = ((MedicalRecord) p).viewRecords();
                System.out.println("Medical Records:");
                for (String r : records) {
                    System.out.println("- " + r);
                }
            }
        }
    }
}
