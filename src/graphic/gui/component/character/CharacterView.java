package graphic.gui.component.character;

import graphic.Updatable;
import graphic.gui.component.Drawable;
import model.GameParameters;
import model.Location;

import java.awt.Graphics;
import java.awt.Color;

public abstract class CharacterView implements Updatable, Drawable {
    protected int x;
    protected int y;
    protected Color mainColor;

    private CharacterView(int x, int y, Color mainColor) {
        this.x = x;
        this.y = y;
        this.mainColor = mainColor;
    }

    protected CharacterView() {
        this(0, 0, Color.BLACK);
    }

    protected CharacterView(Color mainColor) {
        this(0, 0, mainColor);
    }

    protected void drawFromRects(Graphics g) {
        int locationX = x * GameParameters.BLOCK_WIDTH;
        int locationY = y * GameParameters.BLOCK_HEIGHT;
        
        int x = locationX;
        int y = locationY;

        g.setColor(mainColor);
        g.fillRect(x, y, GameParameters.BLOCK_WIDTH, GameParameters.BLOCK_HEIGHT);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, GameParameters.BLOCK_WIDTH, GameParameters.BLOCK_HEIGHT);
    }

    protected void updateLocation(Location location) {
        this.x = location.x;
        this.y = location.y;
//        System.out.println("setting location to " + this.x + "," + this.y);
    }

    @Override
    public void draw(Graphics g) {
        drawFromRects(g);
    }
}
