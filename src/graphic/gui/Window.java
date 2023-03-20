package graphic.gui;

import javax.swing.*;

import graphic.Updatable;
import graphic.gui.component.CanvasPanel;
import graphic.gui.component.Panel;
import model.GameParameters;
import model.GameState;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements Updatable {
    private final Panel mainPanel;
    private char keyPressed;

    public Window() {
        mainPanel = new CanvasPanel();
        setContentPane(mainPanel);

        setTitle("Pacman");
        startInWindow();
        setupKeybaordListener();
    }

    private void startInWindow() {
        setSize(GameParameters.SCREEN_WIDTH, GameParameters.SCREEN_HEIGHT + 25 /* up bar */);
        setLocationRelativeTo(null);
    }
    
    private void startInFullScreen() {
        setLocation(0, 0);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setUndecorated(true);
    }

    @Override
    public void update(GameState gameState) {
        mainPanel.update(gameState);
    }

    public void redraw() {
        this.invalidate();
        this.validate();
        this.repaint();
    }

    public void start() {
        setVisible(true);
    }

    private void setupKeybaordListener() {
        keyPressed = 0;

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                keyPressed = Character.toUpperCase(e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                keyPressed = 0;
            }
        });
    }

    public char getPlayerInput() {
        return keyPressed;
    }
}
