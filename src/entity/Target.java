package entity;

import entity.animation.PlayerDirection;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Target extends Entity {

    GamePanel gamePanel;
    BufferedImage targetImage;

    public Target(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 400;
        y = 300;
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_1.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void update() {

    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(up1, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
