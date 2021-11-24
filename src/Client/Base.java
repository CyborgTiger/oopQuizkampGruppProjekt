package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Base extends JFrame {

    StartMenuDesign smd = new StartMenuDesign();
    Backend gameGUI = new Backend();
    Client client = new Client();
    int chosenAnswer = -1;
    int correctAnswer = -1;

    Base() {
        setTitle("Quizkampen");
        setSize(500, 550);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        smd.newGameButton.addMouseListener(buttonClick);
        add(smd);
        add(gameGUI).setVisible(false);
    }

    MouseAdapter buttonClick = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) throws ClassCastException {
            Object src = e.getSource();
            if (src == smd.newGameButton) {
                smd.setVisible(false);
                gameGUI.setVisible(true);
                correctAnswer = gameGUI.game(client.quizQuestions);
            }
            if (src == gameGUI.optionOne) {
                chosenAnswer = 0;
                client.answerResult(chosenAnswer == correctAnswer);
            }
            if (src == gameGUI.optionTwo) {
                chosenAnswer = 1;
                client.answerResult(chosenAnswer == correctAnswer);
            }
            if (src == gameGUI.optionThree) {
                chosenAnswer = 2;
                client.answerResult(chosenAnswer == correctAnswer);
            }
            if (src == gameGUI.optionFour) {
                chosenAnswer = 3;
                client.answerResult(chosenAnswer == correctAnswer);
            }
        }
    };

    public static void main(String[] args) {
        new Base();

    }
}