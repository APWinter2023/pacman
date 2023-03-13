package model.characters.enemy;

import model.Action;

public class EnemyX extends EnemyLinear {

    public EnemyX(int x, int y) {
        super(x, y);
    }

    @Override
    public Action nextAction() {
        return new Action(getDelta(), 0, x, y);
    }
}
