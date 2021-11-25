package Client;

import Server.QuizCategories;
import Server.QuizQuestion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;
import javax.swing.*;


public class Client extends JFrame implements ActionListener {

    private BufferedReader in;
    private PrintWriter out;

    StartMenuDesign smd = new StartMenuDesign();
    GameGUI gameGUI = new GameGUI();
    Scoreboard scoreBoard = new Scoreboard();
    QuizCategories quizCategories = new QuizCategories();
    Category category = new Category();
    Logic logic = new Logic();
    String name;
    int points;
    int questionNr;
    int questionCategory;
    int answer;
    int delay=4000;
    boolean correct;

    public Client() {

        setTitle("Quizkampen");
        setSize(500, 550);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        smd.newGameButton.addMouseListener(buttonClick);
        add(smd);
        add(gameGUI).setVisible(false);
        add(scoreBoard).setVisible(false);
        add(category).setVisible(false);

        gameGUI.optionOne.addMouseListener(buttonClick);
        gameGUI.optionTwo.addMouseListener(buttonClick);
        gameGUI.optionThree.addMouseListener(buttonClick);
        gameGUI.optionFour.addMouseListener(buttonClick);

        category.optionOne.addMouseListener(buttonClick);
        category.optionTwo.addMouseListener(buttonClick);
        category.optionThree.addMouseListener(buttonClick);
        category.optionFour.addMouseListener(buttonClick);
        category.optionFive.addMouseListener(buttonClick);
        category.optionSix.addMouseListener(buttonClick);


        String hostName = "127.0.0.1";  //localhost
        int portNumber = 12345;


        try {
            Socket socket = new Socket(hostName, portNumber);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String fromServer;

            while ((fromServer = (String) in.readLine()) != null) {
                scoreBoard.txt.append(fromServer + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    MouseAdapter buttonClick = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) throws ClassCastException {
            Object src = e.getSource();

            if (src == gameGUI.optionOne) {
                answer = 0;
                gameGUI.correctAnswer.setText(logic.correctAnswerTexted(quizCategories,questionCategory,questionNr,answer));

                correct = logic.correctAnswer(quizCategories,questionCategory, questionNr, answer);
                if(!correct){
                    gameGUI.optionOne.setBackground(Color.RED);

                } else{
                    gameGUI.optionOne.setBackground(Color.green);
                    points++;
                }
                timer();
            }
            if (src == gameGUI.optionTwo) {
                answer = 1;
                gameGUI.correctAnswer.setText(logic.correctAnswerTexted(quizCategories,questionCategory,questionNr,answer));

                correct = logic.correctAnswer(quizCategories,questionCategory, questionNr, answer);
                if(!correct){
                    gameGUI.optionTwo.setBackground(Color.RED);
                } else{
                    gameGUI.optionTwo.setBackground(Color.green);
                    points++;
                    gameGUI.correctAnswer.setText("Correct!");
                }
                timer();
            }
            if (src == gameGUI.optionThree) {
                answer = 2;
                gameGUI.correctAnswer.setText(logic.correctAnswerTexted(quizCategories,questionCategory,questionNr,answer));

                correct = logic.correctAnswer(quizCategories,questionCategory, questionNr, answer);
                if(!correct){
                    gameGUI.optionThree.setBackground(Color.RED);
                } else{
                    gameGUI.optionThree.setBackground(Color.green);
                    points++;
                    gameGUI.correctAnswer.setText("Correct!");
                }
                timer();
            }
            if (src == gameGUI.optionFour) {
                answer = 3;
                gameGUI.correctAnswer.setText(logic.correctAnswerTexted(quizCategories,questionCategory,questionNr,answer));

                correct = logic.correctAnswer(quizCategories,questionCategory, questionNr, answer);
                if(!correct){
                    gameGUI.optionFour.setBackground(Color.RED);
                } else{
                    gameGUI.optionFour.setBackground(Color.green);
                    points++;
                    gameGUI.correctAnswer.setText("Correct!");
                }
                timer();
            }
            if (src == smd.newGameButton) {
                name = smd.userNameInput.getText();
                smd.setVisible(false);
                category.setVisible(true);
            }

            if(src == category.optionOne){
                category.setVisible(false);
                gameGUI.setVisible(true);
                questionCategory=0;
                gameGUI.setConstants(quizCategories, questionCategory, questionNr);
            }

            if(src == category.optionTwo){
                category.setVisible(false);
                gameGUI.setVisible(true);
                questionCategory=1;
                gameGUI.setConstants(quizCategories,questionCategory,questionNr);
            }
            if(src == category.optionThree){
                category.setVisible(false);
                gameGUI.setVisible(true);
                questionCategory=2;
                gameGUI.setConstants(quizCategories,questionCategory,questionNr);
            }

            if(src == category.optionFour){
                category.setVisible(false);
                gameGUI.setVisible(true);
                questionCategory=3;
                gameGUI.setConstants(quizCategories,questionCategory,questionNr);
            }

            if(src == category.optionFive){
                category.setVisible(false);
                gameGUI.setVisible(true);
                questionCategory=4;
                gameGUI.setConstants(quizCategories,questionCategory,questionNr);
            }

            if(src == category.optionSix){
                category.setVisible(false);
                gameGUI.setVisible(true);
                gameGUI.setConstants(quizCategories,5,questionNr);
            }


        }
    };

    public static void main(String[] args) {
        Client c = new Client();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void timer(){
        Timer timer = new Timer(delay, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                gameGUI.setConstants(quizCategories,questionCategory,questionNr);
                gameGUI.optionOne.setBackground(null);
                gameGUI.optionTwo.setBackground(null);
                gameGUI.optionThree.setBackground(null);
                gameGUI.optionFour.setBackground(null);
                gameGUI.correctAnswer.setText("");
            }
        });
        timer.start();
        questionNr++;

        if (questionNr==5){
            questionNr=0;
            gameGUI.setVisible(false);
            scoreBoard.setVisible(true);
            out.println(name + " Antal poäng: " + points);
        }
    }

}