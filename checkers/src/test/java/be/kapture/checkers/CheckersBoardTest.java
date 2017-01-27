package be.kapture.checkers;

import static be.kapture.checkers.Color.BLACK;
import static be.kapture.checkers.Color.WHITE;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CheckersBoardTest {
	private CheckersBoard checkersBoard;

	@Before
	public void setup() {
		checkersBoard = new CheckersBoard();
	}

	@Test
	public void getManMoves() {
		assertThat(checkersBoard.getManMoves(new PawnLocation(3, 5), WHITE), 
				contains(new PawnLocation(2, 6), new PawnLocation(4, 6)));
		
		assertThat(checkersBoard.getManMoves(new PawnLocation(3, 5), BLACK), 
				contains(new PawnLocation(2, 4), new PawnLocation(4, 4)));

	}
	
	@Test
	public void getManMoves_LeftBorder() {
		assertThat(checkersBoard.getManMoves(new PawnLocation(0, 4), WHITE), 
				contains(new PawnLocation(1,5)));
		
		assertThat(checkersBoard.getManMoves(new PawnLocation(0, 4), BLACK), 
				contains(new PawnLocation(1,3)));

	}
	
	@Test
	public void getManMoves_Right() {
		assertThat(checkersBoard.getManMoves(new PawnLocation(9, 3), WHITE), 
				contains(new PawnLocation(8, 4)));
		
		assertThat(checkersBoard.getManMoves(new PawnLocation(9, 3), BLACK), 
				contains(new PawnLocation(8, 2)));

	}
	

	@Test
	public void getManTakes() {
		assertThat(checkersBoard.getManTakes(new PawnLocation(3, 5)), 
				contains(new PawnLocation(1, 7), new PawnLocation(5, 7), new PawnLocation(5, 3), new PawnLocation(1, 3)));
	}
	
	@Test
	public void getManTakes_Upper() {
		assertThat(checkersBoard.getManTakes(new PawnLocation(3, 9)), 
				contains(new PawnLocation(5, 7), new PawnLocation(1, 7)));
		
		assertThat(checkersBoard.getManTakes(new PawnLocation(2, 8)), 
				contains(new PawnLocation(4, 6), new PawnLocation(0, 6)));

	}
	
//	public void getManTakes_Upper() {
//	public void getManTakes_Lower() {
//	public void getManTakes_Left() {
//	public void getManTakes_Right() {


	
	@Test(expected= NullPointerException.class)
	public void getMoves_NullLocation() {
		checkersBoard.getManMoves(null, WHITE);
	}
	
	@Test(expected= NullPointerException.class)
	public void getMoves_NulColor() {
		checkersBoard.getManMoves(new PawnLocation(3, 3), null);
	}

}
