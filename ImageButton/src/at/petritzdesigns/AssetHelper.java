package at.petritzdesigns;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * ImageButton
 * 
 * @author Markus Petritz
 * @version 1.0.0
 */
public class AssetHelper {
    
    /**
     * Get Image from given path
     * @param filename the path
     * @return image as BufferedImage
     * @throws IOException if the image could not be read
     */
    public static BufferedImage getImage(String filename) throws IOException {
        return ImageIO.read(new File(filename));
    }
}
