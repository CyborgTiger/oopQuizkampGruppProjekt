import javax.swing.*;
import javax.xml.stream.events.StartElement;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartMenuDesign extends JFrame {

    // top panel
    JPanel top = new JPanel();
    JPanel topRight = new JPanel();
    JPanel topLeft = new JPanel();
    JPanel insideTopLeft = new JPanel();

    JLabel userName = new JLabel("Username: ");
    JButton saveUserInputButton = new JButton("Save");
    JTextArea userNameInput = new JTextArea();

    // Center panel
    JPanel center = new JPanel();
    JPanel topCenter = new JPanel();
    JPanel bottomCenter = new JPanel();
    JLabel welcomeMessage = new JLabel("               ");
    String s = "";
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
        userNameInput.setBackground(Color.pink);
        userNameInput.setFont(new Font("Serif", Font.BOLD, 25));

        topRight.add(saveUserInputButton);
        saveUserInputButton.addMouseListener(buttonClick);

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
           

            if (src == saveUserInputButton) {
                s = userNameInput.getText();
                welcomeMessage.setText("Välkommen " + s);


            }


        }

    };


    public static void main(String[] args) {
        new StartMenuDesign();
    }

}
