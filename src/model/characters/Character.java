package model.characters;

import model.Action;
import model.Location;

public abstract class Character {
    protected int x;
    protected int y;

    protected Character(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract Action nextAction();

    public void move(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
    }

    public Location getLocation() {
        return new Location(x, y);
    }

    public boolean isPlayer() {
        return this instanceof Pacman;
    }
}
