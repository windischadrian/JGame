package entity;

import main.GamePanel;
import utils.JGameUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

import static utils.JGameConfig.*;

public class Target extends Entity {

    GamePanel gamePanel;

    public Target(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        setDefaultValues();
    }

    public void setDefaultValues() {
        x = JGameUtils.randomNumberFromInterval(sideWallsSize, screenWidth - sideWallsSize);
        y = JGameUtils.randomNumberFromInterval(transversalWallsSize, screenHeight - transversalWallsSize);
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/player/player_down_1.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void update() {}

    public void draw(Graphics2D g2d) {
        g2d.drawImage(idle, x, y, tileSize, tileSize, null);
    }
}
