package entity.animation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class PlayerDirection {

    public Direction up;
    public Direction left;
    public Direction down;
    public Direction right;

    public PlayerDirection() {
        setDirections();
    }

    private void setDirections() {
        setUp();
        setLeft();
        setDown();
        setRight();
    }

    private void setUp() {
        ArrayList<BufferedImage> sprites = new ArrayList<>();
        try {

            sprites.add(ImageIO.read(getClass().getResourceAsStream("/player/player_up_1.png")));
            sprites.add(ImageIO.read(getClass().getResourceAsStream("/player/player_up_2.png")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        up = new Direction(sprites);
    }

    private void setLeft() {
        ArrayList<BufferedImage> sprites = new ArrayList<>();
        try {
            sprites.add(ImageIO.read(getClass().getResourceAsStream("/player/player_left_1.png")));
            sprites.add(ImageIO.read(getClass().getResourceAsStream("/player/player_left_2.png")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        left = new Direction(sprites);
    }

    private void setDown() {
        ArrayList<BufferedImage> sprites = new ArrayList<>();
        try {
            sprites.add(ImageIO.read(getClass().getResourceAsStream("/player/player_down_1.png")));
            sprites.add(ImageIO.read(getClass().getResourceAsStream("/player/player_down_2.png")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        down = new Direction(sprites);
    }

    private void setRight() {
        ArrayList<BufferedImage> sprites = new ArrayList<>();
        try {
            sprites.add(ImageIO.read(getClass().getResourceAsStream("/player/player_right_1.png")));
            sprites.add(ImageIO.read(getClass().getResourceAsStream("/player/player_right_2.png")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        right = new Direction(sprites);
    }
}
