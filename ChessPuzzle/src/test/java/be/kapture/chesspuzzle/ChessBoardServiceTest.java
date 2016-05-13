package be.kapture.chesspuzzle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static be.kapture.chesspuzzle.ChessBoardService.NOT_FOUND;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import org.hamcrest.Matchers;

/**
 * Created by cromhjo on 10/05/2016.
 */
public class ChessBoardServiceTest {

    private static final Tile INITIAL_TILE = new Tile(2, 3);
    private static final Tile TILE1A = new Tile(3, 4);
    private static final Tile TILE1B = new Tile(6, 6);
    private static final Tile TILE2A = new Tile(5, 6);
    private static final Tile TILE2B = new Tile(5, 5);
    private static final Tile TILE2C = new Tile(6, 5);
    private ChessBoardService chessBoardService;
	private ChessBoard chessBoard;

    @Before
    public void setup(){
    	 chessBoard = mock(ChessBoard.class);
         chessBoardService = new ChessBoardService(chessBoard);
    }
    
    @Test
    public void getOccupiedTiles() throws Exception {
       

        when(chessBoard.doHorseMove(INITIAL_TILE)).thenReturn(asList( TILE1A, TILE1B));
        when(chessBoard.doHorseMove(TILE1A)).thenReturn(asList( TILE2A));
        when(chessBoard.doHorseMove(TILE1B)).thenReturn(asList( TILE2B, INITIAL_TILE));

        chessBoardService.getOccupiedTiles(INITIAL_TILE);

        verify(chessBoard, times(1)).doHorseMove(INITIAL_TILE);
        verify(chessBoard).doHorseMove(TILE2A);
        verify(chessBoard).doHorseMove(TILE2B);
    }

    @Test
    public void getOccupiedTiles_ReturnsAllTiles(){ //integration test
    	chessBoardService = new ChessBoardService(new ChessBoard());
        
        assertThat(chessBoardService.getOccupiedTiles(INITIAL_TILE), hasSize(64));
    }
    
    @Test
    public void getNumberOfMoves_SamePlace(){
    	int numberOfMoves = chessBoardService.getNumberOfMoves(TILE1A, TILE1A);
    	
    	assertThat(numberOfMoves, is(0));
    }
    
    @Test(expected= IllegalArgumentException.class)
    public void getNumberOfMoves_NullStart(){
    	chessBoardService.getNumberOfMoves(null, TILE1A);
    }
    
    @Test(expected= IllegalArgumentException.class)
    public void getNumberOfMoves_NullEnd(){
    	chessBoardService.getNumberOfMoves(TILE1A, null);
    }

    @Test
    public void getNumberOfMoves(){
    	Tile startTile = new Tile(1,2);
    	Tile endTile = new Tile(3,3);

    	when(chessBoard.doHorseMove(startTile)).thenReturn(asList(TILE1A, TILE1B));
    	
    	when(chessBoard.doHorseMove(TILE1A)).thenReturn(asList(TILE2A));
    	when(chessBoard.doHorseMove(TILE1B)).thenReturn(asList(TILE2B));
    	
    	when(chessBoard.doHorseMove(TILE2A)).thenReturn(asList(startTile));
    	when(chessBoard.doHorseMove(TILE2B)).thenReturn(asList(TILE2C, endTile));
		
    	assertThat(chessBoardService.getNumberOfMoves(startTile, endTile), is(3));
    }
    
    @Test
    public void getNumberOfMoves_noSolution(){
    	Tile startTile = new Tile(1,2);
    	Tile endTile = new Tile(3,3);

    	when(chessBoard.doHorseMove(startTile)).thenReturn(asList(TILE1A));
    	when(chessBoard.doHorseMove(TILE1A)).thenReturn(asList(TILE2A));
    	when(chessBoard.doHorseMove(TILE2A)).thenReturn(asList(startTile));
		
    	assertThat(chessBoardService.getNumberOfMoves(startTile, endTile), is(NOT_FOUND));
    }

    

}