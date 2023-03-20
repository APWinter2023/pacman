package characters.enemy;

import model.Action;

public class EnemyY extends EnemyLinear {
    public EnemyY(int x, int y, int id) {
        super(x, y, id);
    }

    @Override
    public Action nextAction() {
        return new Action(0, getDelta(), x, y);
    }
}
