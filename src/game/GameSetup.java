package game;

import characters.enemy.EnemyType;

public class GameSetup {
    public void initBoard(Board board) {
        board.addPacman(0, 0);
        board.addEnemy(0, 2);
        board.addEnemy(1, 4, EnemyType.Y);
        board.addEnemy(4, 5, EnemyType.X);
        board.addBlock(4, 4);
        board.addBlock(2, 2);
    }
}
