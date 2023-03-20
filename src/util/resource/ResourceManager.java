package util.resource;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ResourceManager {
    private final Map<String, BufferedImage> loadedImages;

    public ResourceManager() {
        loadedImages = new HashMap<>();
    }

    /**
     * 
     * @param path relative path of image file
     * @return buffered image
     * @throws IOException
     */
    public BufferedImage loadImage(String path) throws IOException {
        if (loadedImages.containsKey(path)) {
            return loadedImages.get(path);
        }
        BufferedImage image = ImageIO.read(new File(relativeToFilepath(path)));
        loadedImages.put(path, image);
        return image;
    }

    private String relativeToFilepath(String relativePath) {
        return System.getProperty("user.dir") +
            "/"  + "resource/image/" + relativePath;
    }

    public BufferedImage loadImage(ImagePath image) throws IOException {
        return loadImage(image.toString());
    }
}
