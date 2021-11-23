package Client;

import Server.QuizQuestions;

public class Backend extends GameGUI{
    public void game(QuizQuestions questions){
        String question = questions.getQuizQuestions().get(1).getQuestion();
        String[] answers = questions.getQuizQuestions().get(1).getAnswers();
        int correctAnswerIndex = questions.getQuizQuestions().get(1).getCorrectAnswerIndex();
        setConstants(answers, question);
        //new thread that waits for time out
        //main thread checks waits for input
        //sends answer to server (ASK SIGRUND IF OKAY FOR CLIENT TO CHECK ANSWERS AND SEND THAT TO SERVER SO IT UPDATES POINTS)
        //shows if correct or incorrect depending on the servers response
        //next question repeat process 4 times
        question = questions.getQuizQuestions().get(2).getQuestion();
        answers = questions.getQuizQuestions().get(2).getAnswers();
        correctAnswerIndex = questions.getQuizQuestions().get(2).getCorrectAnswerIndex();
        setConstants(answers, question);
    }
}
