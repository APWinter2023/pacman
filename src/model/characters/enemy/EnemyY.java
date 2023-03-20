package model.characters.enemy;

import model.Action;

class EnemyY extends EnemyLinear {
    protected EnemyY(int x, int y, int id) {
        super(x, y, id);
    }

    @Override
    public Action nextAction() {
        return new Action(0, getDelta(), x, y);
    }
}
