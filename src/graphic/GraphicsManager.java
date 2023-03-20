package graphic;

public class GraphicsManager {
    private static IGraphics instance;

    public static IGraphics getInstance() {
        return instance;
    }

    public static void setInstance(IGraphics instance) {
        GraphicsManager.instance = instance;
    }
}
