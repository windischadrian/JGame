package main;

import entity.Player;

import javax.swing.*;
import java.awt.*;
import java.security.Key;
import java.util.Objects;

public class GamePanel extends JPanel implements Runnable{

    //Window config
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    final int maxScreenColumns = 16;
    final int maxScreenRows = 12;
    final int screenWidth = tileSize * maxScreenColumns;
    final int screenHeight = tileSize * maxScreenRows;

    //Player coords + movement
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    //Game frames per second
    int gameFPS = 60;
    int milli = 1000;
    int frameTime = milli/gameFPS;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyHandler);


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while(!Objects.isNull(gameThread)) {

            long t0 = System.currentTimeMillis();

            //Updating information on screen
            update();

            //Drawing the screen with the updated information
            repaint();

            try {
                long t1= System.currentTimeMillis();

                Thread.sleep(frameTime - (t1-t0));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        player.draw(g2d);

        g2d.dispose();
    }
}
