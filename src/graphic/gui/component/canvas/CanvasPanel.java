package graphic.gui.component.canvas;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import graphic.gui.component.ComponentFactory;
import graphic.gui.component.Drawable;
import graphic.gui.component.abstracts.BallView;
import model.GameState;
import characters.Character;
import model.Location;

public class CanvasPanel extends Panel {

    private final List<Drawable> components;

    public CanvasPanel() {
        components = new ArrayList<>();
        setLayout(null);
        setBackground(Color.WHITE);
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
