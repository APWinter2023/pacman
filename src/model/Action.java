package model;

public class Action {
    public final int deltaX;
    public final int deltaY;
    public final int x;
    public final int y;

    public Action(int deltaX, int deltaY, int x, int y) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.x = x;
        this.y = y;
    }
}
