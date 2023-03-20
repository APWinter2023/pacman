package graphic.gui.component.abstracts;

import graphic.gui.component.Drawable;
import model.Location;

public abstract class GuiComponent implements Drawable {
    protected int x;
    protected int y;

    protected GuiComponent(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public GuiComponent() {
        this(0,0);
    }

    protected void updateLocation(Location location) {
        this.x = location.x;
        this.y = location.y;
    }
}
