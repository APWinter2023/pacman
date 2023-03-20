package graphic.gui.component.character;

import game.GameParameters;
import graphic.gui.component.abstracts.RectComponent;
import util.resource.ImagePath;
import util.resource.ResourceManager;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class CharacterView extends RectComponent {
    private CharacterView(int x, int y, Color mainColor) {
        super(x, y, mainColor);
    }

    protected CharacterView() { this(Color.BLACK); }

    protected CharacterView(Color mainColor) {
        super(mainColor);
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


    @Override
    public void draw(Graphics g) {
        drawFromRects(g);
    }
}
