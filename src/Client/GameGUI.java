package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends JPanel implements ActionListener {

    String question = "What is the origin of the Olympic Games?";
    String[] answers1 = {"Scandinavia", "Greece", "China", "Egypt"};

    JPanel questionPanel = new JPanel();
    JPanel optionPanel = new JPanel();
    JButton optionOne = new JButton("Option 1");
    JButton optionTwo = new JButton("Option 2");
    JButton optionThree = new JButton("Option 3");
    JButton optionFour = new JButton("Option 4");
    JLabel questionLabel = new JLabel("Question?");


    public GameGUI(){

        setVisible(true);
        setLayout(new BorderLayout());
        setSize(500,500);

        optionPanel.setPreferredSize(new Dimension(100,300));
        optionPanel.setSize(100,300);
        optionPanel.setLayout(new GridLayout(2,2));

        questionLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));
        questionPanel.add(questionLabel, BorderLayout.NORTH);
        questionPanel.updateUI();

        add(questionPanel, BorderLayout.NORTH);
        add(optionPanel, BorderLayout.SOUTH);

        addOptions();
        setConstants(answers1, question);

    }

    public void createButtons() {
        Dimension buttonSize = new Dimension(1,1);
        optionOne.setPreferredSize(buttonSize);
        optionTwo.setPreferredSize(buttonSize);
        optionThree.setPreferredSize(buttonSize);
        optionFour.setPreferredSize(buttonSize);
    }

    public void addOptions() {
        createButtons();
        optionPanel.add(optionOne);
        optionPanel.add(optionTwo);
        optionPanel.add(optionThree);
        optionPanel.add(optionFour);
        optionOne.addActionListener(this);
        optionTwo.addActionListener(this);
        optionThree.addActionListener(this);
        optionFour.addActionListener(this);
    }

    public void setConstants(String[] options, String question) {
        questionLabel.setText(question);
        optionOne.setText(options[0]);
        optionTwo.setText(options[1]);
        optionThree.setText(options[2]);
        optionFour.setText(options[3]);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() != null) {
            System.out.println(e.getSource().toString());
        }

    }
}
