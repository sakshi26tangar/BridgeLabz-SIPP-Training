import java.util.*;

class Patient {
    String name;

    Patient(String name) {
        this.name = name;
    }
}

class Doctor {
    String name;
    List<Patient> patients = new ArrayList<>();

    Doctor(String name) {
        this.name = name;
    }

    void consult(Patient p) {
        patients.add(p);
        System.out.println(name + " consulted " + p.name);
    }
}

class Hospital {
    String name;

    Hospital(String name) {
        this.name = name;
    }
}
