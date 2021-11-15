package Client;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StartMenuDesign extends JFrame {

    JPanel top = new JPanel();
    JPanel userInfo= new JPanel();
    JPanel savedUserInfo = new JPanel();
    JPanel saveButton = new JPanel();
    JPanel newGame = new JPanel();
    JPanel bottom = new JPanel();

    JButton play = new JButton("Starta nytt spel");
    JButton button2 = new JButton("button 2");
    JButton button3 = new JButton("button 3");
    JButton button4 = new JButton("button 4");
    JButton saveNameButton = new JButton("Spara");

    JLabel username = new JLabel("USERNAME: ");
    JTextArea inputTxt = new JTextArea();

    JButton homebutton = new JButton("Hem");

    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

    StartMenuDesign() {

        //top
        top.setLayout(new GridLayout(1,2));

        userInfo.setBackground(Color.pink);
        userInfo.add(username);
        userInfo.add(inputTxt);
        userInfo.setBorder(border);

        saveButton.setLayout(new GridLayout(1,2));
        top.add(userInfo);
        top.add(saveButton);
        saveButton.add(saveNameButton);


        //Center

        //South

        userInfo.setLayout(new GridLayout(1,3));
        savedUserInfo.setLayout(new GridLayout(1,2));

        setLayout(new FlowLayout());

        play.setFont(new Font("Serif", Font.BOLD, 17));
        play.setForeground(Color.BLACK);
        play.setBorder(border);
        play.setPreferredSize(new Dimension(480, 30));
        play.setBackground(Color.green);

        inputTxt.setBackground(Color.pink);
        inputTxt.setFont(new Font("Serif", Font.BOLD, 17));

        newGame.setBackground(Color.pink);


        
        bottom.add(homebutton);
        bottom.add(button2);
        bottom.add(button3);
        bottom.add(button4);
        bottom.setBorder(border);

        add(userInfo);
        add(newGame);
        add(bottom);

        newGame.add(play);


        //JFrame properties
        setTitle("Quizkampen");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {
        new StartMenuDesign();
    }

}