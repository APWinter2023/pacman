package graphic.gui.component.abstracts;

import game.GameParameters;
import graphic.gui.component.abstracts.GuiComponent;

import java.awt.*;

public class RectComponent extends GuiComponent {
    protected final Color mainColor;

    protected RectComponent(int x, int y, Color mainColor) {
        super(x, y);
        this.mainColor = mainColor;
    }

    public RectComponent(Color mainColor) {
        this.mainColor = mainColor;
    }

    protected void drawFromRects(Graphics g) {
        int posX = x * GameParameters.BLOCK_WIDTH;
        int posY = y * GameParameters.BLOCK_HEIGHT;

        g.setColor(mainColor);
        g.fillRect(posX, posY, GameParameters.BLOCK_WIDTH, GameParameters.BLOCK_HEIGHT);
        g.setColor(Color.BLACK);
        g.drawRect(posX, posY, GameParameters.BLOCK_WIDTH, GameParameters.BLOCK_HEIGHT);
    }

    @Override
    public void draw(Graphics g) {
        drawFromRects(g);
    }
}
