package model;

public class GameParameters {
    private GameParameters() {}
    
    public static final int SCREEN_WIDTH = 400;
    public static final int SCREEN_HEIGHT = 400;
    
    private static final int X_PIXELS = 10;
    private static final int Y_PIXELS = 10;

    public static final int BLOCK_WIDTH = SCREEN_WIDTH / X_PIXELS;
    public static final int BLOCK_HEIGHT = SCREEN_HEIGHT / Y_PIXELS;
}
