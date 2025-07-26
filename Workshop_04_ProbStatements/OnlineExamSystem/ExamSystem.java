import java.util.*;

public class ExamSystem {
    private List<Subject> subjects = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void registerStudent(Student student) {
        students.add(student);
    }

    public Subject getSubjectByName(String name) {
        for (Subject s : subjects) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public int calculateScore(Student student, Subject subject, String difficulty) {
        List<Question<String>> questions = subject.getQuestionsByDifficulty(difficulty);
        List<String> submitted = student.getAnswers(subject.getName());

        int score = 0;
        for (int i = 0; i < questions.size() && i < submitted.size(); i++) {
            if (questions.get(i).getCorrectAnswer().equalsIgnoreCase(submitted.get(i))) {
                score++;
            }
        }
        return score;
    }
}
