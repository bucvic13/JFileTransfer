package at.petritzdesigns;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * ImageButton
 *
 * @author Markus Petritz
 * @version 1.0.0
 */
public class ImageHelper {

    /**
     * Scales Buffered Image with given size
     *
     * @param img the image to scale
     * @param width the width
     * @param height the height
     * @return new image as buffered image
     */
    public static BufferedImage scale(BufferedImage img, int width, int height) {
        return toBufferedImage(img.getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    /**
     * Converts Image to Buffered Image
     *
     * @param img the image to convert
     * @return new image as buffered image
     */
    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        BufferedImage bimg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = bimg.createGraphics();
        g2.drawImage(img, 0, 0, null);
        g2.dispose();

        return bimg;
    }

    /**
     * Converts Icon to Buffered Image
     *
     * @param ico the icon to convert
     * @return new image as buffered image
     */
    public static BufferedImage toBufferedImage(Icon ico) {
        if (ico instanceof ImageIcon) {
            return toBufferedImage(((ImageIcon) ico).getImage());
        }

        BufferedImage bimg = new BufferedImage(ico.getIconWidth(), ico.getIconHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = bimg.createGraphics();
        ico.paintIcon(null, g2, 0, 0);
        g2.dispose();

        return bimg;
    }

    /**
     * Colors all pixels that are not transparent to the given color
     *
     * @param img the image to color
     * @param color the color
     * @return new colored image
     */
    public static BufferedImage coloredImage(BufferedImage img, Color color) {
        int width = img.getWidth();
        int height = img.getHeight();
        WritableRaster raster = img.getRaster();

        for (int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                int[] pixels = raster.getPixel(xx, yy, (int[]) null);
                pixels[0] = color.getRed();
                pixels[1] = color.getGreen();
                pixels[2] = color.getBlue();
                raster.setPixel(xx, yy, pixels);
            }
        }

        return img;
    }
}
