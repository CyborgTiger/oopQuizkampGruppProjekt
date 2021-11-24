package Client;
import javax.swing.*;
import java.awt.*;

public class Scoreboard extends JPanel {
    JPanel box = new JPanel();
    JTextArea txt = new JTextArea();
    JLabel j = new JLabel("hej hej");
    JButton jb = new JButton("tja");

    Scoreboard(){
        setVisible(true);
        setLayout(new BorderLayout());
        setSize(500,500);
        add(box, BorderLayout.CENTER);
        box.setLayout(new GridLayout(2,2));
        box.add(txt);
        txt.setFont(new Font("Serif", Font.BOLD, 20));
    }

    public static void main(String[] args) {
        new Scoreboard();
    }
}
