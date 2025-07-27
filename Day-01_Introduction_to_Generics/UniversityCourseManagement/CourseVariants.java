class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based");
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluation through final written exam.");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based");
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluation through periodic assignments.");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based");
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluation through research paper and presentation.");
    }
}
