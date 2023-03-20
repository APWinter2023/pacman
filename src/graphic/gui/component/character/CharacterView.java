package graphic.gui.component.character;

import graphic.gui.component.Drawable;
import model.GameParameters;
import model.Location;
import util.ImagePath;
import util.ResourceManager;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class CharacterView implements Drawable {
    protected int x;
    protected int y;
    protected Color mainColor;

    private CharacterView(int x, int y, Color mainColor) {
        this.x = x;
        this.y = y;
        this.mainColor = mainColor;
    }

    protected CharacterView() {
        this(0, 0, Color.BLACK);
    }

    protected CharacterView(Color mainColor) {
        this(0, 0, mainColor);
    }

    protected void drawFromRects(Graphics g) {
        int posX = x * GameParameters.BLOCK_WIDTH;
        int posY = y * GameParameters.BLOCK_HEIGHT;

        g.setColor(mainColor);
        g.fillRect(posX, posY, GameParameters.BLOCK_WIDTH, GameParameters.BLOCK_HEIGHT);
        g.setColor(Color.BLACK);
        g.drawRect(posX, posY, GameParameters.BLOCK_WIDTH, GameParameters.BLOCK_HEIGHT);
    }

    protected void drawFromImage(Graphics g, ImagePath path) {
        BufferedImage image;
        try {
            image = new ResourceManager().loadImage(path);
            g.drawImage(
                    image,
                    x * GameParameters.BLOCK_WIDTH, y * GameParameters.BLOCK_HEIGHT,
                    GameParameters.BLOCK_WIDTH, GameParameters.BLOCK_HEIGHT,
                    null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void updateLocation(Location location) {
        this.x = location.x;
        this.y = location.y;
    }

    @Override
    public void draw(Graphics g) {
        drawFromRects(g);
    }
}
