import org.junit.Test;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * Created by cromhjo on 10/05/2016.
 */
public class ChessBoardTest {

    private ChessBoard chessBoard= new ChessBoard();

    @Test
    public void doHorseMove(){
        Tile startTile = new Tile(5, 5);

        assertThat(chessBoard.doHorseMove(startTile), containsInAnyOrder(new Tile(3,4), new Tile(4,3), new Tile(7,6), new Tile(6,7),
                new Tile(7,4), new Tile(6,3), new Tile (3,6), new Tile( 4,7)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void doHorseMove_Null(){
        chessBoard.doHorseMove(null);
    }

    @Test
    public void doHorseMove_UpperBounds(){
        Tile maxTile = new Tile(Tile.MAX, Tile.MAX);

        assertThat(chessBoard.doHorseMove(maxTile), containsInAnyOrder(new Tile(6,5), new Tile(5,6)));
    }

    @Test
    public void doHorseMove_LowerBounds(){
        Tile maxTile = new Tile(Tile.MIN, 1);

        assertThat(chessBoard.doHorseMove(maxTile), containsInAnyOrder(new Tile(2,0), new Tile(2,2), new Tile(1,3)));
    }



}