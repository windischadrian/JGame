package entity.animation;

import java.awt.image.BufferedImage;
import java.util.List;

public class Direction {

    List<BufferedImage> sprites;
    int lastImage=0;
    int counter=0;

    Direction(List<BufferedImage> sprites) {
        this.sprites = sprites;
    }

    public BufferedImage nextImage() {
        counter++;
        if(counter%10!=0) {
            return sprites.get(lastImage);
        } else {
            counter=0;
            lastImage++;
            if(sprites.size()>lastImage) {
                return sprites.get(lastImage);
            } else {
                lastImage=0;
                return sprites.get(lastImage);
            }
        }
    }

}
