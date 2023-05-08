package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player extends Entity {

    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update() {
        if(keyHandler.upButton) y-=speed;
        if(keyHandler.leftButton) x-=speed;
        if(keyHandler.downButton) y+=speed;
        if(keyHandler.rightButton) x+=speed;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.white);
        g2d.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
    }
}
