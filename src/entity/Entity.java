package entity;

import entity.animation.Direction;
import main.GamePanel;

import java.awt.image.BufferedImage;

import static utils.JGameConfig.tileSize;

public class Entity {
    public int x, y;
    public int speed;

    public BufferedImage up1, up2, left1, left2, down1, down2, right1, right2, idle;
    public Direction direction;
    public GamePanel gamePanel;

    public boolean isColided(int x, int y) {
        return (
                ((this.x+tileSize >= x) && (this.y+tileSize >= y))
                        && ((this.x <= x+tileSize) && (this.y <= y+tileSize))
        );
    }

    public boolean isColided(Entity entity) {
        return (
                ((x+tileSize >= entity.x) && (y+tileSize >= entity.y))
                && ((x <= entity.x+tileSize) && (y <= entity.y+tileSize))
        );
    }

    /**
     *
     *  ((x+tileSize) >= this.x) && (x+tileSize <= this.x+tileSize))
     *
     *
     *
     *
     */
}
