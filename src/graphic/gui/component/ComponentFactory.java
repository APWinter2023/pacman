package graphic.gui.component;

import graphic.gui.component.character.EnemyView;
import graphic.gui.component.character.PacmanView;
import characters.Character;
import characters.enemy.Enemy;

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
