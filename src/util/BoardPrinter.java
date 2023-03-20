package util;

import characters.Character;
import characters.enemy.EnemyX;

public class BoardPrinter {
    public void printBoard(int width, int height, Character[][] chars) {
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
