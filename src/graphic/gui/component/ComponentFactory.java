package graphic.gui.component;

import graphic.gui.component.character.EnemyView;
import graphic.gui.component.character.PacmanView;
import characters.Character;
import characters.enemy.Enemy;
import game.GameParameters;
import model.Location;

public class ComponentFactory {
    private Drawable makeCharacter(Character character) {
        if (character.isPlayer()) return new PacmanView();
        if (character instanceof Enemy) return makeEnemy((Enemy) character);
        return emptyComponent();
    }

    private Drawable makeEnemy(Enemy enemy) {
        return new EnemyView(enemy.getID(), enemy.getType());
    }

    private Drawable makeBlock(Location block) {
        return new BlockView(block.x, block.y);
    }

    public Drawable make(Object object) {
        if (object instanceof Location) return makeBlock((Location) object);
        if (object instanceof Character) return makeCharacter((Character) object);
        return emptyComponent();
    }

    public Drawable makeVerticalLine(int x) {
        return g -> {
            g.drawLine(
                x * GameParameters.BLOCK_WIDTH, 
                0, 
                x * GameParameters.BLOCK_WIDTH, 
                GameParameters.SCREEN_HEIGHT
                );
        };
    }

    public Drawable makeHorizontalLine(int y) {
        return g -> g.drawLine(
            0, 
            y * GameParameters.BLOCK_HEIGHT, 
            GameParameters.SCREEN_WIDTH, 
            y * GameParameters.BLOCK_HEIGHT
            );
    }

    private Drawable emptyComponent() {
        return g -> {};
    }
}
