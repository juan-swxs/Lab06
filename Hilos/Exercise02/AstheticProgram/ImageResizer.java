package Hilos.Exercise02.AstheticProgram;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class ImageResizer {
    
    public static ImageIcon resizeIcon(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage();
        
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImage.createGraphics();
        
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        
        return new ImageIcon(resizedImage);
    }
    
    

}
