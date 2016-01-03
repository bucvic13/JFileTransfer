package at.petritzdesigns;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * ImageButton
 *
 * @author Markus Petritz
 * @version 1.0.0
 */
public class ImageButton extends JButton {

    /**
     * Default Color of the image
     */
    private Color defaultColor = Color.black;

    /**
     * Primary Color when clicked
     */
    private Color primaryColor = Color.blue;

    /**
     * Disabled Color when disabled
     */
    private Color disabledColor = Color.gray;

    /**
     * Hover Color when hovered
     */
    private Color hoverColor = Color.darkGray;

    /**
     * Image Size (regardless to the button size)
     */
    private Dimension imageSize = new Dimension(64, 64);

    /**
     * Default Constructor
     */
    public ImageButton() {
        super();
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setBorderPainted(false);
        this.setBackground(new Color(0, 0, 0, 1));
    }

    /**
     * Paint method
     *
     * @param g graphics object
     */
    @Override
    protected void paintComponent(Graphics g) {
        try {
            BufferedImage img = ImageHelper.toBufferedImage(getIcon());
            if (img != null) {
                //set to default color
                img = ImageHelper.coloredImage(img, defaultColor);

                int w = getWidth();
                int h = getHeight();
                int x = (w - img.getWidth()) / 2;
                int y = (h - img.getHeight()) / 2;

                //set hover color
                if (getModel().isRollover()) {
                    img = ImageHelper.coloredImage(img, hoverColor);
                }

                //set pressed color
                if (getModel().isPressed()) {
                    img = ImageHelper.coloredImage(img, primaryColor);
                }

                //set disabled color
                if (!isEnabled()) {
                    img = ImageHelper.coloredImage(img, disabledColor);
                }

                g.drawImage(img, x, y, this);
            }
        } catch (Exception ex) {
            //ignore
            System.err.println(ex);
        }
    }

    public Color getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(Color primaryColor) {
        this.primaryColor = primaryColor;
    }

    public Color getDisabledColor() {
        return disabledColor;
    }

    public void setDisabledColor(Color disabledColor) {
        this.disabledColor = disabledColor;
    }

    public Dimension getImageSize() {
        return imageSize;
    }

    public void setImageSize(Dimension imageSize) {
        this.imageSize = imageSize;
    }

    public Color getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(Color defaultColor) {
        this.defaultColor = defaultColor;
    }

    public Color getHoverColor() {
        return hoverColor;
    }

    public void setHoverColor(Color hoverColor) {
        this.hoverColor = hoverColor;
    }
}
