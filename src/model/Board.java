package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.characters.Character;
import model.characters.Pacman;
import model.characters.enemy.EnemyX;
import model.characters.enemy.EnemyY;

public class Board {
    private Character[][] chars;
    private final List<Character> charList;

    private final int width;
    private final int height;

    private int enemyCount;
    private static Random random = new Random(); // used to select enemy type

    public Board(int width, int height) {
        enemyCount = 0;

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

        if (
            newX >= 0
            && newY >= 0
            && newX < width
            && newY < height
            && chars[newX][newY] == null
        ) {
            Character c = chars[action.x][action.y];
            c.move(action.deltaX, action.deltaY);
            chars[newX][newY] = c;
            chars[action.x][action.y] = null; 
        }    
    }

    private void addCharacter(int x, int y, Character c) {
        chars[x][y] = c;
        charList.add(c);
    }

    public void addEnemy(int x, int y) {
        if (random.nextInt(2) == 0) {
            addCharacter(x, y, new EnemyX(x, y, enemyCount));
        } else {
            addCharacter(x, y, new EnemyY(x, y, enemyCount));
        }
        enemyCount++;
    }
    
    public void addPacman(int x, int y) {
        addCharacter(x, y, new Pacman(x, y));
    }

    public List<Character> getCharacters() {
        return charList;
    }

    public void printBoard() {
        for (int i = 0; i<width; ++i) {
            for (int j = 0; j<height; ++j) {
                Character c = chars[i][j];
                if (c == null) {
                    System.out.print("-");
                } else {
                    if (c.isPlayer()) {
                        System.out.print("@");
                    } else if(c instanceof EnemyX) {
                        System.out.print("X");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
