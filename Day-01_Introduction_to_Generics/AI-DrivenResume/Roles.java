class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    @Override
    public boolean isEligible() {
        return experienceYears >= 2;
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    @Override
    public boolean isEligible() {
        return experienceYears >= 3;
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    @Override
    public boolean isEligible() {
        return experienceYears >= 5;
    }
}
