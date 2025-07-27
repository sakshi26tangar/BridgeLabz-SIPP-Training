abstract class JobRole {
    protected String candidateName;
    protected int experienceYears;

    public JobRole(String candidateName, int experienceYears) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }

    public abstract boolean isEligible();

    public String getCandidateName() {
        return candidateName;
    }
}
