package Client;
import Server.QuizCategories;
import Server.QuizQuestion;
import Server.QuizQuestions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.Socket;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Collection;
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

        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  //true for autoflush
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
            ;
            while(true){
                /*String input = in.readLine();
                if (input == null) {
                    return;
                }*/
                if (match.getRound() == 4){
                    out2.writeObject(question2cat2);
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
                if (match.getRound() == 3){
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
                if (match.getRound() == 2){
                    out2.writeObject(question2cat1);
                    out2.flush();
                    while(in2.readObject() == null){}
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
                if (match.getRound() == 1){
                    out2.writeObject(question1cat1);
                    out2.flush();
                    while(in2.readObject() == null){}
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
                for (PrintWriter writer : multiWriter.getWriters()) {
                    //writer.println(input);
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}