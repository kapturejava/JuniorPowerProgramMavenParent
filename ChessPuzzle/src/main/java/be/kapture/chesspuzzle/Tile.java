package be.kapture.chesspuzzle;
import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by cromhjo on 10/05/2016.
 */
public class Tile {
    static final int MIN = 0;
    static final int MAX = 7;
    private final int x;
    private final int y;

    public Tile(int x, int y) {
        if(! isValid(x, y)) {
            throw new IllegalArgumentException();
        }
        this.x = x;
        this.y = y;
    }

    public static boolean isValid(int x, int y) {
        return min(x,y) >= MIN && max(x,y) <= MAX;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tile tile = (Tile) o;

        if (x != tile.x) return false;
        return y == tile.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }


}
