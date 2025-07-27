import java.util.*;

class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public void processResume() {
        System.out.println("Processing resume for: " + jobRole.getCandidateName());
        if (jobRole.isEligible()) {
            System.out.println("Status: Eligible for further rounds.\n");
        } else {
            System.out.println("Status: Not eligible.\n");
        }
    }
}

public class ResumeSystem {
    public static void screenAll(List<? extends JobRole> resumes) {
        for (JobRole role : resumes) {
            Resume<? extends JobRole> resume = new Resume<>(role);
            resume.processResume();
        }
    }

    public static void main(String[] args) {
        List<JobRole> applicants = new ArrayList<>();
        applicants.add(new SoftwareEngineer("Alice", 3));
        applicants.add(new DataScientist("Bob", 2));
        applicants.add(new ProductManager("Charlie", 6));
        applicants.add(new ProductManager("Daisy", 4));

        screenAll(applicants);
    }
}
