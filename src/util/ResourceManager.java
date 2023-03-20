package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ResourceManager {
    /**
     * 
     * @param path relative path of image file
     * @return buffered image
     * @throws IOException
     */
    public BufferedImage loadImage(String path) throws IOException {
        BufferedImage image = ImageIO.read(new File(relativeToFilepath(path)));
        return image;
    }

    private String relativeToFilepath(String relativePath) {
        return System.getProperty("user.dir") + "/" + relativePath;
    }
}
