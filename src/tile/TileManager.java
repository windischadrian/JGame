package tile;

import main.GamePanel;
import utils.JGameConfig;

import javax.imageio.ImageIO;
import java.awt.*;

import static utils.JGameConfig.*;
import static utils.JGameConfig.tileSize;

public class TileManager {

    GamePanel gamePanel;
    Tile[] tile;

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        tile = new Tile[10];

        getTileImage();
    }

    private void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].tileImage = ImageIO.read(getClass().getResourceAsStream("/environment/grass.png"));

            tile[1] = new Tile();
            tile[1].tileImage = ImageIO.read(getClass().getResourceAsStream("/environment/wall.png"));
            tile[2].collision = true;

            tile[2] = new Tile();
            tile[2].tileImage = ImageIO.read(getClass().getResourceAsStream("/environment/water.png"));
            tile[2].collision = true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d) {
        for (int row = 0; row < maxScreenRows; row++) {
            for (int column = 0; column < maxScreenColumns; column++) {
                int x = column * tileSize;
                int y = row * tileSize;

                if(row == 0 || row == maxScreenRows-1 || column == 0 || column == maxScreenColumns-1) {
                    g2d.drawImage(tile[1].tileImage, x, y, tileSize, tileSize, null); //walls on the outside
                } else {
                    g2d.drawImage(tile[0].tileImage, x, y, tileSize, tileSize, null); //grass on the inside
                }
            }
        }
    }
}
