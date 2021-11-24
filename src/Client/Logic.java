package Client;

import Server.QuizCategories;

public class Logic {


    Logic(){}

    public boolean correctAnswer(QuizCategories quizCategories, int questionCategory, int questionNr, int answer) {

        if (answer == quizCategories.getQuizCategories().get(questionCategory).getQuizQuestions()
                .get(questionNr).getCorrectAnswerIndex()) {
            return true;
        }
        return false;
    }

    public String correctAnswerTexted(QuizCategories quizCategories, int questionCategory, int questionNr, int answer) {

        if (answer == quizCategories.getQuizCategories().get(questionCategory).getQuizQuestions()
                .get(questionNr).getCorrectAnswerIndex()) {
            return "Correct!";
        }
        else {
            return "Correct answer was: " + quizCategories.getQuizCategories().get(questionCategory).getQuizQuestions().get(questionNr).getAnswers()
                    [quizCategories.getQuizCategories().get(questionCategory).getQuizQuestions()
                    .get(questionNr).getCorrectAnswerIndex()];
        }

    }


}
