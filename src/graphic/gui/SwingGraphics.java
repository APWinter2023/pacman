package graphic.gui;

import graphic.IGraphics;
import model.GameState;

import java.awt.EventQueue;
import java.util.concurrent.TimeUnit;

public class SwingGraphics implements IGraphics {
    private final Window window;

    public SwingGraphics() {
        window = new Window();
    }

    @Override
    public void update(GameState state) {
        window.update(state);
    }

    @Override
    public void start() {
        window.start();

        int fps = 5; // Frame per second
        new Thread(() -> {
            while(true) {
                try {
                    redraw();
                    TimeUnit.MILLISECONDS.sleep(1000/fps);
                } catch (InterruptedException ignored) {}
            }
        }).start();
    }

    @Override
    public char getPlayerInput() {
        return window.getPlayerInput();
    }

    @Override
    public synchronized void redraw() {
        EventQueue.invokeLater(window::redraw);
    }
}
