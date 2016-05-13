package be.kapture.chesspuzzle;
import org.junit.Test;

/**
 * Created by cromhjo on 10/05/2016.
 */
public class TileTest {

    @Test(expected = IllegalArgumentException.class)
    public void Tile_XtooLow(){
        new Tile(Tile.MIN -1, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Tile_XtooHigh(){
        new Tile(Tile.MAX+1, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Tile_YtooLow(){
        new Tile(6, Tile.MIN -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Tile_YtooHigh(){
        new Tile(6, Tile.MAX+1);
    }

    @Test
    public void Tile(){
        new Tile(Tile.MIN, Tile.MAX);
    }


}