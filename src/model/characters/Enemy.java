package model.characters;

import model.characters.enemy.EnemyX;
import model.characters.enemy.EnemyY;

public abstract class Enemy extends Character {
    private int id;

    protected Enemy(int x, int y, int id) {
        super(x, y);
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public EnemyType getType() {
        if (this instanceof EnemyX) return EnemyType.X;
        if (this instanceof EnemyY) return EnemyType.Y;
        return null;
    }
}
