package graphic.gui.component;

import model.GameState;

import java.awt.*;

public class Ball implements Drawable {

    @Override
    public void draw(Graphics g) {
        g.drawArc(100, 100, 100, 100, 0, 270);
    }

    @Override
    public void update(GameState state) {

    }
}
