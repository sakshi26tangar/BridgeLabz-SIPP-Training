public class Question<T> {
    private String questionText;
    private String difficulty;
    private String[] options;
    private T correctAnswer;

    public Question(String questionText, String difficulty, String[] options, T correctAnswer) {
        this.questionText = questionText;
        this.difficulty = difficulty;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String[] getOptions() {
        return options;
    }

    public T getCorrectAnswer() {
        return correctAnswer;
    }
}
