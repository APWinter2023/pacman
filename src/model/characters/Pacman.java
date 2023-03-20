package model.characters;

import graphic.GraphicsManager;
import model.Action;

/**
 * player
 */
public class Pacman extends Character {

    public Pacman(int x, int y) {
        super(x, y);
    }

    @Override
    public Action nextAction() {
        return play(GraphicsManager.getInstance().getPlayerInput());
    }

    private Action play(char c) {
        switch(c) {
            case 'W':
                return new Action(0, -1, x, y);
            case 'A':
                return new Action(-1, 0, x, y);
            case 'S':
                return new Action(0, 1, x, y);
            case 'D':
                return new Action(1, 0, x, y);
        }
        return new Action(0, 0, x, y);
    }
}
