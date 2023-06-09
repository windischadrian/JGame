package main;

import entity.Player;
import entity.Target;
import tile.TileManager;
import utils.JGameConfig;
import utils.JGameUtils;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

import static utils.JGameConfig.*;

public class GamePanel extends JPanel implements Runnable{

    TileManager tileManager = new TileManager(this);
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

            update();

            repaint();

            try {
                long t1= System.currentTimeMillis();

                Thread.sleep(JGameConfig.frameTime - (t1-t0));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        player.update();
        if(player.isColided(target)) {
            target.x = JGameUtils.randomNumberFromInterval(sideWallsSize, screenWidth - sideWallsSize - tileSize);
            target.y = JGameUtils.randomNumberFromInterval(transversalWallsSize, screenHeight - transversalWallsSize - tileSize);
        }
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        tileManager.draw(g2d);
        player.draw(g2d);
        target.draw(g2d);

        g2d.dispose();
    }
}
