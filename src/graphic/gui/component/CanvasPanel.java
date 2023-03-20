package graphic.gui.component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import graphic.gui.component.character.CharacterView;
import model.GameState;
import model.characters.Character;

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
        for (Character c : gameState.getCharacters()) {
            Drawable comp = componentFactory.make(c);
            add(comp);
            comp.update(gameState);
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

    private synchronized void draw(Graphics g, Drawable component) {
        component.draw(g);
    }
}
