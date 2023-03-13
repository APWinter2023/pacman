package model.characters;

import java.io.Console;
import java.util.Scanner;

import model.Action;

/**
 * player
 */
public class Pacman extends Character {

    private final Scanner scanner;
    
    public Pacman(int x, int y) {
        super(x, y);
        scanner = new Scanner(System.in);
    }

    @Override
    public Action nextAction() {
        System.out.println("Enter your next move (WASD)");
        String line = scanner.nextLine();
        return play(line.charAt(0));
    }
    
    private Action play(char c) {
        switch(c) {
            case 'W':
            return new Action(0, 1, x, y);
            case 'A':
            return new Action(-1, 0, x, y);
            case 'S':
            return new Action(0, -1, x, y);
            case 'D':
            return new Action(0, 1, x, y);
        }
        return new Action(0, 0, x, y);
    }
}
