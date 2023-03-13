package model.characters;

import model.Action;

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
}
