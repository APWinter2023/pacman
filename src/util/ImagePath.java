package util;


public enum ImagePath {
    PACMAN, ENEMY_PINK, ENEMY_ORANGE;

    @Override
    public String toString() {
        if (this == ImagePath.PACMAN) {
            return super.toString().toLowerCase() + "_image.jpeg";
        }
        return super.toString().toLowerCase() + "_image.png";
    }
}
