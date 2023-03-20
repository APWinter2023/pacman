package game;

import java.awt.*;

public class GameParameters {
    private GameParameters() {}
    
    public static final int SCREEN_WIDTH = 440;
    public static final int SCREEN_HEIGHT = 440;
    
    public static final int X_PIXELS = 8;
    public static final int Y_PIXELS = 8;

    public static final int BLOCK_WIDTH = SCREEN_WIDTH / X_PIXELS;
    public static final int BLOCK_HEIGHT = SCREEN_HEIGHT / Y_PIXELS;

    /** frame per second, display update rate */
    public static final int FPS = 10;

    public static final Color CANVAS_COLOR = Color.LIGHT_GRAY;
}
