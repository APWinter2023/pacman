package graphic.gui.component.abstracts;

import game.GameParameters;
import graphic.gui.component.Drawable;
import model.GameState;

import java.awt.*;

public class BallView extends GuiComponent {

    @Override
    public void draw(Graphics g) {
        g.drawArc(
                x, y,
                GameParameters.BLOCK_WIDTH, GameParameters.BLOCK_HEIGHT,
                0, 360);
    }
}
