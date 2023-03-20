package model;

import java.util.List;

import characters.Pacman;
import characters.Character;
import characters.enemy.Enemy;
import game.Board;

public class GameState {
    private final Board board;

    public GameState(Board board) {
        this.board = board;
    }

    public List<Character> getCharacters() {
        return board.getCharacters();
    }

    public Pacman getPacman() {
        return (Pacman) getCharacters().get(0);
    }

    public Enemy getEnemy(int id) {
        return (Enemy) getCharacters().get(1 + id);
    }
    
    public Board getBoard() {
        return board;
    }
}
