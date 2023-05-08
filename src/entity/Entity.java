package entity;

import entity.animation.Direction;

import java.awt.image.BufferedImage;

public class Entity {
    public int x, y;
    public int speed;

    public BufferedImage up1, up2, left1, left2, down1, down2, right1, right2;
    public Direction direction;
}
