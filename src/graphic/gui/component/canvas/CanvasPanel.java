package graphic.gui.component.canvas;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import graphic.gui.component.ComponentFactory;
import graphic.gui.component.Drawable;
import model.GameState;
import characters.Character;
import game.GameParameters;
import model.Location;

public class CanvasPanel extends Panel {

    private final List<Drawable> components;

    public CanvasPanel() {
        components = new ArrayList<>();
        setLayout(null);
        setBackground(GameParameters.CANVAS_COLOR);
    }

    public void add(Drawable c) {
        components.add(c);
    }

    private void initiatePanels(GameState gameState) {
        ComponentFactory componentFactory = new ComponentFactory();
        // characters
        for (Character c : gameState.getCharacters()) {
            Drawable comp = componentFactory.make(c);
            add(comp);
            comp.update(gameState);
        }
        // blocks
        for (Location block : gameState.getBlocks()) {
            add(componentFactory.make(block));
        }

        for (int i=1; i<GameParameters.SCREEN_WIDTH-2; ++i) {
            add(componentFactory.makeVerticalLine(i));
        }

        for (int i=1; i<GameParameters.SCREEN_HEIGHT-2; ++i) {
            add(componentFactory.makeHorizontalLine(i));
        }
    }

    @Override
    public void update(GameState gameState) {
        components.clear();
        initiatePanels(gameState);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Drawable component : components) {
            draw(g, component);
        }
    }

    private void draw(Graphics g, Drawable component) {
        component.draw(g);
    }
}
