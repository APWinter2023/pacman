package graphic.gui.component.character;

import model.GameState;
import model.Location;
import util.ImagePath;

import java.awt.*;


public class EnemyView extends CharacterView {
    private final int id;

    public EnemyView(int id) {
        super(Color.RED);
        this.id = id;
    }

    @Override
    public void update(GameState gameState) {
        Location location = gameState.getEnemy(id).getLocation();
        updateLocation(location);
    }

    @Override
    public void draw(Graphics g) {
        drawFromImage(g, ImagePath.ENEMY_PINK);
    }
}
