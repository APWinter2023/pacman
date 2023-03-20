package graphic.gui.component.character;

import model.GameState;
import model.Location;
import characters.enemy.EnemyType;
import util.resource.ImagePath;

import java.awt.*;


public class EnemyView extends CharacterView {
    private final int id;
    private EnemyType type;

    public EnemyView(int id) {
        super(Color.RED);
        this.id = id;
    }

    public EnemyView(int id, EnemyType type) {
        this(id);
        this.type = type;
    }

    @Override
    public void update(GameState gameState) {
        Location location = gameState.getEnemy(id).getLocation();
        updateLocation(location);
    }

    @Override
    public void draw(Graphics g) {
        if (type == EnemyType.X)
            drawFromImage(g, ImagePath.ENEMY_PINK);
        else
            drawFromImage(g, ImagePath.ENEMY_ORANGE);
    }


}
