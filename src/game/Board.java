package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import characters.Character;
import characters.Pacman;
import characters.enemy.Enemy;
import characters.enemy.EnemyType;
import characters.enemy.EnemyX;
import characters.enemy.EnemyY;
import model.Action;
import util.BoardPrinter;

public class Board {
    private Character[][] chars;
    private final List<Character> charList;

    private final int width;
    private final int height;

    private final EnemyGenerator enemyGenerator;

    public Board(int width, int height) {
        enemyGenerator = new EnemyGenerator();

        this.height = height;
        this.width = width;
        charList = new ArrayList<>();

        chars = new Character[width][height];

        for (int i = 0; i<width; ++i) {
            for (int j = 0; j<height; ++j) {
                chars[i][j] = null;
            }
        }
    }

    public void play(Action action) {
        int newX = action.x + action.deltaX;
        int newY = action.y + action.deltaY;

        if (isMoveAllowed(newX, newY)) {
            Character c = chars[action.x][action.y];
            c.move(action.deltaX, action.deltaY);
            chars[newX][newY] = c;
            chars[action.x][action.y] = null; 
        }    
    }

    private boolean isMoveAllowed(int newX, int newY) {
        return (
                newX >= 0
                && newY >= 0
                && newX < width
                && newY < height
                && chars[newX][newY] == null
        );
    }

    private void addCharacter(int x, int y, Character c) {
        chars[x][y] = c;
        charList.add(c);
    }

    public void addEnemy(int x, int y) {
        addCharacter(x, y, enemyGenerator.randomEnemy(x, y));
    }
    
    public void addPacman(int x, int y) {
        addCharacter(x, y, new Pacman(x, y));
    }

    public List<Character> getCharacters() {
        return charList;
    }

    public void printBoard() {
        new BoardPrinter().printBoard(width, height, chars);
    }
}
