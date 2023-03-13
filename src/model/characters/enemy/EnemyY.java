package model.characters.enemy;

import model.Action;

class EnemyY extends EnemyLinear {
    protected EnemyY(int x, int y) {
        super(x, y);
    }

    @Override
    public Action nextAction() {
        return new Action(0, getDelta(), x, y);
    }
}
