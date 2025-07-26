import java.util.*;

public class Subject {
    private String name;
    private List<Question<String>> questions;

    public Subject(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addQuestion(Question<String> question) {
        questions.add(question);
    }

    public List<Question<String>> getQuestionsByDifficulty(String difficulty) {
        List<Question<String>> filtered = new ArrayList<>();
        for (Question<String> q : questions) {
            if (q.getDifficulty().equalsIgnoreCase(difficulty)) {
                filtered.add(q);
            }
        }
        return filtered;
    }

    public List<Question<String>> getQuestions() {
        return questions;
    }
}
