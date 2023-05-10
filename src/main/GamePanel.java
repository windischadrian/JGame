package main;

import entity.Player;
import entity.Target;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class GamePanel extends JPanel implements Runnable{

    //Window config
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; //48
    final int maxScreenColumns = 16;
    final int maxScreenRows = 12;
    public final int screenWidth = tileSize * maxScreenColumns; //768
    public final int screenHeight = tileSize * maxScreenRows; //576

    public final int sideWallsSize = 52;
    public final int transversalWallsSize = 36;

    final BufferedImage backgroundImage = ImageIO.read(getClass().getResourceAsStream("/environment/background.png"));

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
    Target target = new Target(this);


    public GamePanel() throws IOException {
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
        g.drawImage(backgroundImage, 0, 0, null);

        Graphics2D g2d = (Graphics2D) g;

        player.draw(g2d);
        target.draw(g2d);

        g2d.dispose();
    }
}
