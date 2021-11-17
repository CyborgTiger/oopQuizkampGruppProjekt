package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends Base implements ActionListener {

    JPanel questionPanel = new JPanel();
    JPanel optionPanel = new JPanel();
    JButton optionOne = new JButton("optionOne");
    JButton optionTwo = new JButton("optionTwo");
    JButton optionThree = new JButton("optionThree");
    JButton optionFour = new JButton("optionFour");
    JLabel questionLabel = new JLabel("Lasdasd Oasdasd Qsdasd Asdasa Olasdasd?");

    public GameGUI(){

        setVisible(true);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(Base.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("KampQuizen");
        setSize(700,800);
        add(questionPanel, BorderLayout.NORTH);
        //questionPanel.setPreferredSize(new Dimension(300,300));
        optionPanel.setPreferredSize(new Dimension(600,400));
        optionPanel.setLayout(new GridLayout(2,2));
        add(optionPanel, BorderLayout.CENTER);

        questionLabel.setFont(new Font("Helvetica", Font.PLAIN, 37));
        questionPanel.add(questionLabel, BorderLayout.SOUTH);

        addOptions();

        pack();
    }

    public void createButtons() {
        Dimension buttonSize = new Dimension(100,50);
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


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() != null) {
            System.out.println(e.getSource().toString());
        }

    }
}
