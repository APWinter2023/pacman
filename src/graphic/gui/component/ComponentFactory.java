package graphic.gui.component;

import graphic.gui.component.character.EnemyView;
import graphic.gui.component.character.PacmanView;
import model.characters.Character;
import model.characters.Enemy;
import model.characters.EnemyType;
import model.characters.Pacman;

public class ComponentFactory {
    private Drawable makeCharacter(Character character) {
        if (character.isPlayer()) return new PacmanView();
        if (character instanceof Enemy) return makeEnemy((Enemy) character);
        return emptyComponent();
    }

    private Drawable makeEnemy(Enemy enemy) {
        return new EnemyView(enemy.getID(), enemy.getType());
    }

    public Drawable make(Object object) {
        if (object instanceof Character) return makeCharacter((Character) object);
        return emptyComponent();
    }

    private Drawable emptyComponent() {
        return g -> {};
    }
}
