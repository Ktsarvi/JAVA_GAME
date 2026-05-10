package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class SpriteLoader {

    public static BufferedImage load(String path) {
        BufferedImage img = null;

        // Try classpath first
        InputStream is = SpriteLoader.class.getResourceAsStream("/" + path);
        if (is != null) {
            try {
                img = ImageIO.read(is);
            } catch (IOException e) {
                // fall through
            }
        }

        // Try file system
        if (img == null) {
            File file = new File(path);
            if (file.exists()) {
                try {
                    img = ImageIO.read(file);
                } catch (IOException e) {
                    // fall through
                }
            }
        }

        return img; // null means "use procedural drawing"
    }

    public static BufferedImage[] loadSpriteSheet(String path, int frameWidth, int frameHeight) {
        BufferedImage sheet = load(path);
        if (sheet == null) return null;

        int cols = sheet.getWidth() / frameWidth;
        int rows = sheet.getHeight() / frameHeight;
        BufferedImage[] frames = new BufferedImage[cols * rows];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                frames[row * cols + col] = sheet.getSubimage(
                    col * frameWidth, row * frameHeight, frameWidth, frameHeight
                );
            }
        }
        return frames;
    }
}
