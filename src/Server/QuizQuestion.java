package Server;

public class QuizQuestion {
    private final int correctAnswerIndex;

    private final String question;
    //TODO add catagory


    private final String[] answers;

    public QuizQuestion(String question, int correctAnswerIndex,
                        String... answers) {
        this.question = question;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String[] getAnswers() {
        return answers;
    }

    public String getQuestion() {
        return question;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}
