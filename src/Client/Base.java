package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Base extends JFrame implements MouseListener{

    StartMenuDesign smd = new StartMenuDesign(this);
    GameGUI gameGUI = new GameGUI();


    Base() {
        setTitle("Quizkampen");
        setSize(700, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(smd);
        add(gameGUI).setVisible(false);

        if (smd.shouldShowGame) {
            gameGUI.setVisible(true);
            smd.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Base();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().toString().contains("Starta nytt spel")) {
            System.out.println("Hej");
            smd.setVisible(false);
            gameGUI.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}


