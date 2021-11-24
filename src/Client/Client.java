package Client;

import Server.QuizQuestion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.Socket;
import javax.swing.*;


public class Client extends JFrame implements ActionListener {

    private BufferedReader in;
    private PrintWriter out;

    StartMenuDesign smd = new StartMenuDesign();
    GameGUI gameGUI = new GameGUI();
    Scoreboard scoreBoard = new Scoreboard();
    String name;
    int points = 0;
    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;
    QuizQuestion question;

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

        gameGUI.optionOne.addMouseListener(buttonClick);
        gameGUI.optionTwo.addMouseListener(buttonClick);
        gameGUI.optionThree.addMouseListener(buttonClick);
        gameGUI.optionFour.addMouseListener(buttonClick);

        String hostName = "127.0.0.1";  //localhost
        int portNumber = 55555;

        try {
            Socket socket = new Socket(hostName, portNumber);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String fromServer;
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            while ((fromServer = in.readLine()) != null) {
                System.out.println(fromServer);
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
                boolean result;
                name = smd.userNameInput.getText();
                if(question.getCorrectAnswerIndex() == 0){
                    gameGUI.optionOne.setBackground(Color.GREEN);
                    result = true;
                    points ++;
                } else {
                    gameGUI.optionOne.setBackground(Color.RED);
                    result = false;
                }
                getMoreQuestions(result);
            }
            if (src == gameGUI.optionTwo) {
                boolean result;
                name = smd.userNameInput.getText();
                if(question.getCorrectAnswerIndex() == 0){
                    gameGUI.optionTwo.setBackground(Color.GREEN);
                    result = true;
                    points ++;
                } else {
                    gameGUI.optionTwo.setBackground(Color.RED);
                    result = false;
                }
                getMoreQuestions(result);
            }
            if (src == gameGUI.optionThree) {
                boolean result;
                name = smd.userNameInput.getText();
                if(question.getCorrectAnswerIndex() == 0){
                    gameGUI.optionThree.setBackground(Color.GREEN);
                    result = true;
                    points ++;
                } else {
                    gameGUI.optionThree.setBackground(Color.RED);
                    result = false;
                }
                getMoreQuestions(result);

            }
            if (src == gameGUI.optionFour) {
                boolean result;
                name = smd.userNameInput.getText();
                if(question.getCorrectAnswerIndex() == 0){
                    gameGUI.optionFour.setBackground(Color.GREEN);
                    result = true;
                    points ++;
                } else {
                    gameGUI.optionFour.setBackground(Color.RED);
                    result = false;
                }
                getMoreQuestions(result);
            }
            if (src == smd.newGameButton) {
                smd.setVisible(false);
                gameGUI.setVisible(true);
                try {
                    question = (QuizQuestion) objectInputStream.readObject();
                    gameGUI.setConstants(question.getAnswers(), question.getQuestion());
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }
    };

    private void getMoreQuestions(boolean result) {
        gameGUI.setVisible(false);
        scoreBoard.setVisible(true);
        out.println(name + ": " + points);
        try {
            objectOutputStream.writeObject(new PlayerResult(name, result));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            question = (QuizQuestion) objectInputStream.readObject();
            gameGUI.setConstants(question.getAnswers(), question.getQuestion());
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client c = new Client();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}