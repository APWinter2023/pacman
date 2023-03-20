package graphic.gui.component;

import graphic.gui.component.character.EnemyView;
import graphic.gui.component.character.PacmanView;
import model.characters.Character;
import model.characters.Enemy;
import model.characters.Pacman;

public class ComponentFactory {
    private Drawable makeCharacter(Character character) {
        if (character.isPlayer()) return new PacmanView();
        // TODO: make two view classes for different kinds of enemies
        if (character instanceof Enemy) return new EnemyView(((Enemy) character).getID());
        return emptyComponent();
    }

    public Drawable make(Object object) {
        if (object instanceof Character) return makeCharacter((Character) object);
        return emptyComponent();
    }

    private Drawable emptyComponent() {
        return g -> {};
    }
}
