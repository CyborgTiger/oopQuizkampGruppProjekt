package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Base extends JFrame {

    StartMenuDesign smd = new StartMenuDesign();
    Backend gameGUI = new Backend();
    Client client = new Client();

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
            }
            if (src == gameGUI.optionOne) {
                client.answerChoice(0);
            }
            if (src == gameGUI.optionTwo) {
                client.answerChoice(1);
            }
            if (src == gameGUI.optionThree) {
                client.answerChoice(2);
            }
            if (src == gameGUI.optionFour) {
                client.answerChoice(3);
            }
        }
    };

    public static void main(String[] args) {
        new Base();
    }
}