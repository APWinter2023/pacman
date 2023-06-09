package game;

import java.util.concurrent.TimeUnit;

import graphic.GraphicsManager;
import graphic.IGraphics;
import graphic.gui.SwingGraphics;
import model.GameState;
import characters.Character;

public class Game {
    private final Board board;
    private final GameState state;
    private final IGraphics graphics;

    private Game(IGraphics graphics) {
        this.graphics = graphics;
        GraphicsManager.setInstance(graphics);

        board = new Board(GameParameters.X_PIXELS, GameParameters.Y_PIXELS);
        state = new GameState(board);
        initiateGame();
        graphics.start();
    }

    public Game() {
        this(new SwingGraphics());
    }

    public void initiateGame() {
        new GameSetup().initBoard(board);
    }

    public void loop() {
        // player
        new Thread(() -> {
            while (true) {
                play(state.getPacman());
                sleep(100);
                graphics.update(state);
            }
        }).start();

        // enemies
        new Thread(() -> {
            while (true) {
                for (Character c : board.getCharacters()) {
                    if (c.isPlayer()) continue;
                    play(c);
                    sleep(300);
                }
            }
        }).start();
    }

    private void sleep(int timeoutMs) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeoutMs);
        } catch (InterruptedException ignored) {
            // do nothing
        }
    }

    private synchronized void play(Character c) {
        board.play(c.nextAction());
        graphics.update(state);
    }

}
