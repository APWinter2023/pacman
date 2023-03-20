package graphic.gui.component.character;

import java.awt.Graphics;
import java.awt.Color;

import model.GameParameters;
import model.GameState;
import model.Location;
import util.ResourceManager;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class PacmanView extends CharacterView {

    public PacmanView() {
        super();
        
        mainColor = Color.yellow;
    }

    private void drawFromImage(Graphics g) {
        String imagePath = "pacman_image.jpeg";
        BufferedImage image;
        try {
            image = new ResourceManager().loadImage(imagePath);
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
    public void drawFromRects(Graphics g) {
        super.drawFromRects(g);
        g.fillRect(x+23, y+23, 5, 5);
        g.fillRect(x+73, y+23, 5, 5);
    }

    public void update(GameState state) {
        Location location = state.getPacman().getLocation();
        updateLocation(location);
    }

    @Override
    public void draw(Graphics g) {
        drawFromImage(g);
    }
}
