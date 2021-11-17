package Client;

import javax.swing.*;
import java.awt.*;

public class Base extends JFrame {

    StartMenuDesign smd = new StartMenuDesign();

    Base() {

        setTitle("Quizkampen");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(smd);
    }

    public static void main(String[] args) {
        new Base();
    }

}


