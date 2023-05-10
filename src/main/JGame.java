package main;

import javax.swing.*;

public class JGame {

    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("JGame");

        try {
            GamePanel gamePanel = new GamePanel();
            window.add(gamePanel);
            window.pack();
            window.setVisible(true);

            gamePanel.startGameThread();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
