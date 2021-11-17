package Client;

import javax.swing.*;
import javax.xml.stream.events.StartElement;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.lang.Boolean.TRUE;

public class StartMenuDesign extends JFrame {


    // top panel
    JPanel top = new JPanel();
    JPanel topRight = new JPanel();
    JPanel topLeft = new JPanel();

    JLabel userName = new JLabel("Username: ");
    JButton signInButton = new JButton("Logga in");
    JButton signOutButton = new JButton("Logga ut");
    JButton createUserButton = new JButton("Skapa konto");
    JTextArea userNameInput = new JTextArea();

    // Center panel
    JPanel center = new JPanel();
    JPanel topCenter = new JPanel();
    JPanel bottomCenter = new JPanel();
    JLabel welcomeMessage = new JLabel("               ");
    JButton newGameButton = new JButton("Starta nytt spel");

    // Bottom Panel
    JPanel bottom = new JPanel();
    JButton homeButton = new JButton("Hem");
    JButton statisticsButton = new JButton("Statistik");
    JButton matchHistoryButton = new JButton("Visa historik");
    JButton exitButton = new JButton("Exit");

    StartMenuDesign() {

        //Top panel properties
        add(top, BorderLayout.NORTH);
        top.setLayout(new GridLayout(1, 2));

        top.add(topLeft);
        top.add(topRight);

        topLeft.setLayout(new GridLayout(1, 2));
        topLeft.add(userName);
        topLeft.add(userNameInput);
        userName.setFont(new Font("Serif", Font.BOLD, 15));
        userNameInput.setBackground(Color.pink);
        userNameInput.setFont(new Font("Serif", Font.BOLD, 20));

        topRight.setLayout(new GridLayout(1, 2));
        topRight.add(signInButton);
        topRight.add(createUserButton);

        signInButton.addMouseListener(buttonClick);
        signOutButton.addMouseListener(buttonClick);
        createUserButton.addMouseListener(buttonClick);
        newGameButton.addMouseListener(buttonClick);

        // Center panel properties
        add(center, BorderLayout.CENTER);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        center.add(topCenter, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        center.add(bottomCenter, gbc);

        topCenter.add(welcomeMessage);
        welcomeMessage.setBackground(Color.ORANGE);

        bottomCenter.add(newGameButton);
        newGameButton.setPreferredSize(new Dimension(450, 30));


        // Bottom panel properties
        add(bottom, BorderLayout.SOUTH);
        bottom.setLayout(new FlowLayout());

        bottom.add(homeButton);
        bottom.add(statisticsButton);
        bottom.add(matchHistoryButton);
        bottom.add(exitButton);

        //JFrame properties
        setTitle("Quizkampen");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    MouseAdapter buttonClick = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) throws ClassCastException {

            Object src = e.getSource();
            int clicked = 0;
            String s;
            int line = 0;

            if (src == signInButton) {
                try {
                    BufferedReader inström = new BufferedReader(new FileReader("Users.txt"));
                    String rad = inström.readLine();
                    s = userNameInput.getText();
                    while (rad != null){
                        if (rad.equalsIgnoreCase(s)) {
                            welcomeMessage.setText("Välkommen tillbaka " + s);
                            topRight.remove(signInButton);
                            topRight.remove(createUserButton);
                            topRight.add(signOutButton);
                            topRight.add(createUserButton);
                            userNameInput.setEditable(false);
                            break;
                        } else {
                            rad = inström.readLine();
                            if (rad == null) {
                                JOptionPane.showMessageDialog(null, "Användaren hittas ej - Korrigera felstavning eller" +
                                        " skapa ny användare");
                            }
                        }
                    }


                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (src == signOutButton) {
                s = userNameInput.getText();
                welcomeMessage.setText("Tack för idag " + s + "!");
                userNameInput.setText("");
                topRight.remove(signOutButton);
                topRight.remove(createUserButton);
                topRight.add(signInButton);
                topRight.add(createUserButton);
                userNameInput.setEditable(true);
            }
            if (src == createUserButton) {
                PrintWriter utström = null;
                try {
                    s = JOptionPane.showInputDialog("Skriv in ditt användarnamn");
                    utström = new PrintWriter(new BufferedWriter(new FileWriter("Users.txt", TRUE)));
                    utström.println(s);
                    utström.close();


                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (src == newGameButton){
                GameGUI gg = new GameGUI();
                setVisible(false);
            }
        }

    };

    public static void main(String[] args) throws IOException {
        new StartMenuDesign();
    }

}
