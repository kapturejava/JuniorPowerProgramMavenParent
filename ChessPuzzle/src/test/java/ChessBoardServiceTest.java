import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by cromhjo on 10/05/2016.
 */
public class ChessBoardServiceTest {

    private static final Tile INITIAL_TILE = new Tile(2, 3);
    private static final Tile TILE1A = new Tile(3, 4);
    private static final Tile TILE1B = new Tile(1, 2);
    private static final Tile TILE2A = new Tile(5, 6);
    private static final Tile TILE2B = new Tile(5, 5);
    private ChessBoardService chessBoardService = new ChessBoardService();

    @Test
    public void getOccupiedTiles() throws Exception {
        ChessBoard chessBoard = mock(ChessBoard.class);

        when(chessBoard.doHorseMove(INITIAL_TILE)).thenReturn(asList( TILE1A, TILE1B));
        when(chessBoard.doHorseMove(TILE1A)).thenReturn(asList( TILE2A));
        when(chessBoard.doHorseMove(TILE1B)).thenReturn(asList( TILE2B, INITIAL_TILE));

        chessBoardService.getOccupiedTiles(INITIAL_TILE, chessBoard);

        verify(chessBoard, times(1)).doHorseMove(INITIAL_TILE);
        verify(chessBoard).doHorseMove(TILE2A);
        verify(chessBoard).doHorseMove(TILE2B);
    }

    @Test
    public void getOccupiedTiles_ReturnsAllTiles(){
        ChessBoard chessBoard = new ChessBoard();
        assertEquals(64,chessBoardService.getOccupiedTiles(INITIAL_TILE,chessBoard).size());
    }



}