package graphic;

import model.Action;
import model.GameState;

public interface IGraphics extends Updatable {
    void start();
    char getPlayerInput();
    void redraw();
}
