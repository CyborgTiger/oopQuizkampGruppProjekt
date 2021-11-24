package Client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Client extends JFrame implements ActionListener {

    private BufferedReader in;
    private PrintWriter out;

    StartMenuDesign smd = new StartMenuDesign();
    GameGUI gameGUI = new GameGUI();
    Scoreboard scoreBoard = new Scoreboard();
    String name;
    int points =0;

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
        int portNumber = 12345;


        try {
            Socket socket = new Socket(hostName, portNumber);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String fromServer;

            while ((fromServer = (String)in.readLine()) != null) {
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
                name = smd.userNameInput.getText();
                gameGUI.optionOne.setBackground(Color.RED);
                gameGUI.setVisible(false);
                scoreBoard.setVisible(true);
                out.println(name + ": " + points +"\n");
            }
            if (src == gameGUI.optionTwo) {
                name = smd.userNameInput.getText();
                gameGUI.optionTwo.setBackground(Color.green);
                points ++;
                gameGUI.setVisible(false);
                scoreBoard.setVisible(true);
                out.println(name + ": " + points);
            }
            if (src == gameGUI.optionThree) {
                name = smd.userNameInput.getText();
                gameGUI.optionThree.setBackground(Color.RED);
                gameGUI.setVisible(false);
                scoreBoard.setVisible(true);
                out.println(name + ": " + points);
            }
            if (src == gameGUI.optionFour) {
                name = smd.userNameInput.getText();
                gameGUI.optionFour.setBackground(Color.RED);
                gameGUI.setVisible(false);
                out.println(name + ": " + points);
            }
            if (src == smd.newGameButton) {
                smd.setVisible(false);
                gameGUI.setVisible(true);

            }
        }
    };

    public static void main(String[] args) {
        Client c = new Client();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}