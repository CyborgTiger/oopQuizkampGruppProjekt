package Server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {


    public Server() {

        int portNumber = 44445;

        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter toClient =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader fromClient = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()))
        ) {
            String inputLine;

            toClient.println(sendQuestion());

            while ((inputLine = fromClient.readLine()) != null) {

                if (inputLine.equals("Bye.")){
                    break;
                } else if (!inputLine.equals("")){
                    toClient.println(checkAnswer(inputLine));
                    toClient.println(sendQuestion());
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen "
                    + "on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Server();
    }
        QuizQuestions quizQuestions = new QuizQuestions();

    private String sendQuestion(){

        QuizQuestion quizQuestion = quizQuestions.getQuizQuestions().get(0);
        String question = quizQuestion.getQuestion();
        String[] answers = quizQuestion.getAnswers();
        String answersString = Arrays.toString(answers);
        return question + " " + answersString;
    }

    private String checkAnswer(String answer){
       String correctAnswer = quizQuestions.getQuizQuestions().get(0).getCorrectAnswer();
        if (answer.equals(correctAnswer)){
            return "Correct";
        } else{
            return "Incorrect";
        }
    }
}