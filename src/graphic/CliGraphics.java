package graphic;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import model.Board;
import model.GameState;
import model.characters.Character;

public class CliGraphics implements IGraphics {
    private GameState gameState;
    private Scanner scanner;

    public CliGraphics() {
        scanner = new Scanner(System.in);
    }

    public void loop(Board board) {
        redraw();
        while (true) {
            for (Character c : board.getCharacters()) {
                board.play(c.nextAction());
                redraw();

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    // do nothing
                }
            }
        }
    }

    @Override
    public void start() {
        loop(gameState.getBoard());
    }

    @Override
    public void update(GameState state) {
        this.gameState = state;
    }

    @Override
    public char getPlayerInput() {
         System.out.println("Enter your next move (WASD)");
         String line = scanner.nextLine();
         return line.charAt(0);
    }

    @Override
    public void redraw() {
        gameState.getBoard().printBoard();
    }
}
