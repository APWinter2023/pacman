import graphic.IGraphics;
import graphic.gui.SwingGraphics;
import test.DummyGameState;

public class App {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        game.loop();
    }
}
