package Client;

import javax.swing.*;
import java.awt.*;

public class Category extends JPanel{


    JPanel questionPanel = new JPanel();
    JPanel optionPanel = new JPanel();
    JButton optionOne = new JButton("Geography");
    JButton optionTwo = new JButton("Animals");
    JButton optionThree = new JButton("Sport");
    JButton optionFour = new JButton("Food");
    JButton optionFive = new JButton("Swedish history");
    JButton optionSix = new JButton("Music");

    JLabel questionLabel = new JLabel("Choose category");

    Category(){

        setVisible(true);
        setLayout(new BorderLayout());
        setSize(500,500);

        add(questionPanel, BorderLayout.NORTH);
        add(optionPanel, BorderLayout.CENTER);

        optionPanel.setPreferredSize(new Dimension(100,300));
        optionPanel.setSize(100,300);
        optionPanel.setLayout(new GridLayout(3,2));
        optionPanel.add(optionOne);
        optionPanel.add(optionTwo);
        optionPanel.add(optionThree);
        optionPanel.add(optionFour);
        optionPanel.add(optionFive);
        optionPanel.add(optionSix);


        questionLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));
        questionPanel.add(questionLabel, BorderLayout.NORTH);
        questionPanel.updateUI();


    }


}
