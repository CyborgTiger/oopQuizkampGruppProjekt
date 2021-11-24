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
        System.out.println("Server init!");

        int portNumber = 44444;

        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter toClient =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader fromClient = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()))
        ) {
            System.out.println("Client connected!");

            String inputLine;

            toClient.println("welcome");

            while (true) {
                inputLine = fromClient.readLine();
                if(inputLine != null) {

                    int questionNo = 0;
                    System.out.println(inputLine);
                    if ("requestQuestion".equals(inputLine)) {
                        System.out.println("sending question");

                        toClient.println(sendQuestion(questionNo));

                    }  else  {
                        System.out.println("check answer: " + inputLine + " length:" + inputLine.length());
                        //TODO send results
                        //toClient.println(checkAnswer(questionNo, Integer.parseInt(inputLine.trim())));

                        questionNo++;

                    }
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
    QuizCategories quizQuestions = new QuizCategories();

    private String sendQuestion(int questionNr){

        QuizQuestion quizQuestion = quizQuestions.getQuizCategories().get(questionNr).getQuizQuestions().get(questionNr);
        String question = quizQuestion.getQuestion();
        String[] answers = quizQuestion.getAnswers();
        String answersString = Arrays.toString(answers);
        return question + " " + answersString;

    }
}