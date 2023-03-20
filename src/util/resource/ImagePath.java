package util.resource;


public enum ImagePath {
    PACMAN, ENEMY_PINK, ENEMY_ORANGE, ENEMY_CYAN, ENEMY_RED;

    @Override
    public String toString() {
        if (this == ImagePath.PACMAN) {
            return super.toString().toLowerCase() + "_image.jpeg";
        }
        return super.toString().toLowerCase() + "_image.png";
    }
}
