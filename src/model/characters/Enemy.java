package model.characters;

public abstract class Enemy extends Character {
    private int id;

    protected Enemy(int x, int y, int id) {
        super(x, y);
        this.id = id;
    }

    public int getID() {
        return id;
    }
}
