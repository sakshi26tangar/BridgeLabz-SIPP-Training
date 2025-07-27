public abstract class CourseType {
    protected String evaluationMethod;

    public CourseType(String evaluationMethod) {
        this.evaluationMethod = evaluationMethod;
    }

    public abstract void evaluate();

    public String getEvaluationMethod() {
        return evaluationMethod;
    }
}
