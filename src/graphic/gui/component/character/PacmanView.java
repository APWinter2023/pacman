package graphic.gui.component.character;

import java.awt.Graphics;
import java.awt.Color;

import model.GameState;
import model.Location;
import util.resource.ImagePath;

public class PacmanView extends CharacterView {

    public PacmanView() {
        super(Color.YELLOW);
    }

    @Override
    public void drawFromRects(Graphics g) {
        super.drawFromRects(g);
        // add face
        g.fillRect(x+23, y+23, 5, 5);
        g.fillRect(x+73, y+23, 5, 5);
    }

    @Override
    public void update(GameState state) {
        Location location = state.getPacman().getLocation();
        updateLocation(location);
    }

    @Override
    public void draw(Graphics g) {
        drawFromImage(g, ImagePath.PACMAN);
    }
}
