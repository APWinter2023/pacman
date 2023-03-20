package graphic.gui.component;

import graphic.Updatable;
import model.GameState;

import java.awt.*;

public interface Drawable extends Updatable {
    void draw(Graphics g);

    @Override
    default void update(GameState state) {}
}
