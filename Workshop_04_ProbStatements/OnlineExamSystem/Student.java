import java.util.*;

public class Student {
    private Map<String, List<String>> answers;

    public Student(String name, String rollNumber) {
        this.answers = new HashMap<>();
    }

    public void submitAnswer(String subject, String answer) {
        answers.putIfAbsent(subject, new ArrayList<>());
        answers.get(subject).add(answer);
    }

    public List<String> getAnswers(String subject) {
        return answers.getOrDefault(subject, new ArrayList<>());
    }
}
