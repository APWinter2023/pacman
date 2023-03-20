package model;

import java.util.ArrayList;
import java.util.List;

import model.characters.Character;
import model.characters.Pacman;
import model.characters.enemy.EnemyX;

public class Board {
    private Character[][] chars;
    private final List<Character> charList;

    private final int width;
    private final int height;

    private int enemyCount;

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
        addCharacter(x, y, new EnemyX(x, y, enemyCount));
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
                    if (c instanceof Pacman) {
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
