import java.util.concurrent.TimeUnit;

import model.Board;
import model.characters.Character;

public class Game {
    private final Board board;

    public Game() {
        board = new Board(10, 10);
        initiateGame();
    }

    public void initiateGame() {
        board.addPacman(0, 0);
        board.addEnemy(0, 2);
        board.addEnemy(1, 4);
        board.addEnemy(4, 5);
    }

    public void loop() {
        board.printBoard();
        while (true) {
            for (Character c : board.getCharacters()) {
                board.play(c.nextAction());
                board.printBoard();

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Game().loop();
    }
}
