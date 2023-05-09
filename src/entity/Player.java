package entity;

import entity.animation.PlayerDirection;
import main.GamePanel;
import main.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    GamePanel gamePanel;
    KeyHandler keyHandler;
    BufferedImage playerImage;
    PlayerDirection playerDirection = new PlayerDirection();

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 3;
        playerDirection = new PlayerDirection();
        direction = playerDirection.down;
        playerImage = direction.nextImage();
    }

    public void update() {
        if(keyHandler.upButton) {
            direction=playerDirection.up;
            y = Math.max(y - speed, 0);
        }
        if(keyHandler.leftButton) {
            direction=playerDirection.left;
            x = Math.max(x - speed, 0);
        }
        if(keyHandler.downButton) {
            direction=playerDirection.down;
            y = Math.min(y + speed, gamePanel.screenHeight - gamePanel.tileSize);
        }
        if(keyHandler.rightButton) {
            direction=playerDirection.right;
            x = Math.min(x + speed, gamePanel.screenWidth - gamePanel.tileSize);
        }
        if(keyHandler.anyButton) playerImage = direction.nextImage();
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(playerImage, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
