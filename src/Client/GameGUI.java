package Client;

import Server.QuizCategories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends JPanel implements ActionListener {

    String question = "What is the origin of the Olympic Games?";
    String[] answers1 = {"Scandinavia", "Greece", "China", "Egypt"};
    QuizCategories quizCategories = new QuizCategories();


    JPanel questionPanel = new JPanel();
    JPanel optionPanel = new JPanel();
    JPanel correctAnswerPanel = new JPanel();
    JButton optionOne = new JButton("Option 1");
    JButton optionTwo = new JButton("Option 2");
    JButton optionThree = new JButton("Option 3");
    JButton optionFour = new JButton("Option 4");
    JLabel questionLabel = new JLabel("Question?");
    JLabel correctAnswer = new JLabel("");



    public GameGUI(){

        setVisible(true);
        setLayout(new BorderLayout());
        setSize(500,500);

        optionPanel.setPreferredSize(new Dimension(100,300));
        optionPanel.setSize(100,300);
        optionPanel.setLayout(new GridLayout(2,2));

        questionLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        questionPanel.add(questionLabel, BorderLayout.NORTH);
        questionPanel.updateUI();

        correctAnswerPanel.add(correctAnswer);
        correctAnswer.setFont(new Font("SansSerif", Font.PLAIN, 15));

        add(questionPanel, BorderLayout.NORTH);
        add(correctAnswerPanel, BorderLayout.CENTER);
        add(optionPanel, BorderLayout.SOUTH);

        addOptions();
        //setConstants(answers1, question);

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

    public void setConstants(QuizCategories quizCategories, int buttonClicked, int questionNumber) {

        questionLabel.setText(quizCategories.getQuizCategories().get(buttonClicked).getQuizQuestions().get(questionNumber).getQuestion());

        optionOne.setText(quizCategories.getQuizCategories().get(buttonClicked).getQuizQuestions().get(questionNumber).getAnswers()[0]);
        optionTwo.setText(quizCategories.getQuizCategories().get(buttonClicked).getQuizQuestions().get(questionNumber).getAnswers()[1]);
        optionThree.setText(quizCategories.getQuizCategories().get(buttonClicked).getQuizQuestions().get(questionNumber).getAnswers()[2]);
        optionFour.setText(quizCategories.getQuizCategories().get(buttonClicked).getQuizQuestions().get(questionNumber).getAnswers()[3]);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() != null) {
            System.out.println(e.getSource().toString());
        }

    }
}
