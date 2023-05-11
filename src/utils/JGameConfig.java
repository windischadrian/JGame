package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class JGameConfig {
    //Window config
    final static int originalTileSize = 16;
    final static int scale = 3;

    public static final int tileSize = originalTileSize * scale; //48
    public final static int maxScreenColumns = 16;
    public final static int maxScreenRows = 12;
    public static final int screenWidth = tileSize * maxScreenColumns; //768
    public static final int screenHeight = tileSize * maxScreenRows; //576

    public static final int sideWallsSize = 52;
    public static final int transversalWallsSize = 36;

    //Game frames per second
    public static int gameFPS = 60;
    public static int milli = 1000;
    public static int frameTime = milli/gameFPS;
}
