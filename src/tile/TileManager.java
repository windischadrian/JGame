package tile;

import main.GamePanel;
import utils.JGameConfig;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static utils.JGameConfig.*;
import static utils.JGameConfig.tileSize;

public class TileManager {

    GamePanel gamePanel;
    Tile[] tile;
    int mapTile[][];

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        tile = new Tile[10];
        mapTile = new int[maxScreenColumns][maxScreenRows];

        getTileImage();
    }

    private void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].tileImage = ImageIO.read(getClass().getResourceAsStream("/environment/grass.png"));

            tile[1] = new Tile();
            tile[1].tileImage = ImageIO.read(getClass().getResourceAsStream("/environment/wall.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].tileImage = ImageIO.read(getClass().getResourceAsStream("/environment/water.png"));
            tile[2].collision = true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d) {
        try {
            InputStream is = getClass().getResourceAsStream("/environment/level_1.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            for (int row = 0; row < maxScreenRows; row++) {
                String line = br.readLine();
                for (int column = 0; column < maxScreenColumns; column++) {

                    int tileImage = Character.digit(line.charAt(column),10);

                    int x = column * tileSize;
                    int y = row * tileSize;

                    g2d.drawImage(tile[tileImage].tileImage, x, y, tileSize, tileSize, null);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
