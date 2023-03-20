package game;

import characters.enemy.Enemy;
import characters.enemy.EnemyType;
import characters.enemy.EnemyX;
import characters.enemy.EnemyY;

import java.util.Random;

public class EnemyGenerator {
    private static final Random random = new Random(); // used to select enemy type
    private int enemyCount;

    public EnemyGenerator() {
        enemyCount = 0;
    }

    public Enemy randomEnemy(int x, int y) {
        if (random.nextInt(2) == 0) {
            return newEnemy(x, y, EnemyType.X);
        } else {
            return newEnemy(x, y, EnemyType.Y);
        }
    }

    public Enemy newEnemy(int x, int y, EnemyType type) {
        Enemy enemy;
        if (type == EnemyType.X) {
            enemy = new EnemyX(x, y, enemyCount);
        } else {
            enemy = new EnemyY(x, y, enemyCount);
        }
        enemyCount++;
        return enemy;
    }
}
