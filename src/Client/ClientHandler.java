package Client;

import Server.QuizCategories;
import Server.QuizQuestion;
import Server.QuizQuestions;

import java.io.*;
import java.net.Socket;
import java.util.Collections;

public class ClientHandler extends Thread{

    private Socket socket;
    private MultiWriter multiWriter;
    private QuizCategories quizCategories = new QuizCategories();

    public ClientHandler (Socket socket, MultiWriter multiWriter){
        this.socket = socket;
        this.multiWriter = multiWriter;
    }

    public void run(){

        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            ObjectOutputStream out2 = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in2 = new ObjectInputStream(socket.getInputStream());
            Collections.shuffle(quizCategories.getQuizCategories());
            QuizQuestions category1 = quizCategories.getQuizCategories().get(0);
            QuizQuestions category2 = quizCategories.getQuizCategories().get(1);
            Collections.shuffle(category1.getQuizQuestions());
            Collections.shuffle(category2.getQuizQuestions());
            QuizQuestion question1cat1 = category1.getQuizQuestions().get(0);
            QuizQuestion question2cat1 = category1.getQuizQuestions().get(1);
            QuizQuestion question1cat2 = category2.getQuizQuestions().get(0);
            QuizQuestion question2cat2 = category2.getQuizQuestions().get(1);
            Match match = new Match();


            //Vi lägger in vår printWriter i multiWriters lista
            multiWriter.addWriter(out);

            while (match.getRound() != 5) {
                /*if (in.readLine().equals("start")){
                    out2.writeObject(quizCategories);

                    out2.flush();
                }*/
                if (match.getRound() == 4) {
                    sendAndReceive(out2, in2, question2cat2, match);
                }
                if (match.getRound() == 3) {
                    sendAndReceive(out2, in2, question1cat2, match);
                }
                if (match.getRound() == 2) {
                    sendAndReceive(out2, in2, question2cat1, match);
                }
                if (match.getRound() == 1) {
                    sendAndReceive(out2, in2, question1cat1, match);
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private void sendAndReceive(ObjectOutputStream out2, ObjectInputStream in2, QuizQuestion question1cat2, Match match) throws IOException, ClassNotFoundException {
        out2.writeObject(question1cat2);
        out2.flush();
        PlayerResult playerResult = (PlayerResult) in2.readObject();
        if (playerResult.isResult()){
            if (playerResult.getName().equals("Player 1")){
                match.gainPoint(1);
            }
            if (playerResult.getName().equals("Player 2")){
                match.gainPoint(2);
            }
        }
        match.endRound();
    }

}