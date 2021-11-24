package Client;

import Server.QuizQuestions;

public class Backend extends GameGUI{
    public int game(QuizQuestions questions){
        String question = questions.getQuizQuestions().get(1).getQuestion();
        String[] answers = questions.getQuizQuestions().get(1).getAnswers();

        //setConstants(answers, question);
        return questions.getQuizQuestions().get(1).getCorrectAnswerIndex();
        //main thread checks waits for input

        //shows if correct or incorrect depending on the correct answer
        //sends to server
        //next question repeat process 4 times
    }
}
