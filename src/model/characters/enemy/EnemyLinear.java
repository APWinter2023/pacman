package model.characters.enemy;

import java.util.Random;
import model.characters.Enemy;

abstract class EnemyLinear extends Enemy {
    private final Random random;

    protected EnemyLinear(int x, int y, int id) {
        super(x, y, id);
        random = new Random();
    }

    /** reutrn -1 or 1 */
    protected int getDelta() {
        return random.nextInt(2)*2 - 1;
    }
}
