package be.kapture.connectfour;


import org.junit.Test;

import static be.kapture.connectfour.Colour.RED;
import static be.kapture.connectfour.Colour.YELLOW;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by UnnameDSoS on 14/07/2016.
 */
public class GameBoardTest {

	@Test(expected = IllegalArgumentException.class)
	public void addPiece_ColumnTooLow() {
		GameBoard gameBoard = new GameBoard();

		gameBoard.addPiece(-1, RED);
	}

	@Test(expected = IllegalArgumentException.class)
	public void addPiece_ColumnTooHigh() {
		GameBoard gameBoard = new GameBoard();

		gameBoard.addPiece(GameBoard.NR_OF_COLUMNS, RED);
	}

	@Test(expected = IllegalArgumentException.class)
	public void addPiece_TooManyTimesInSameColumn() {
		GameBoard gameBoard = new GameBoard();

		for (int i = 0; i < GameBoard.NR_OF_ROWS + 1; i++)
			gameBoard.addPiece(0, RED);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getColumn_TooLow() {
		GameBoard gameBoard = new GameBoard();
		gameBoard.getColumn(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getColumn_TooHigh() {
		GameBoard gameBoard = new GameBoard();
		gameBoard.getColumn(GameBoard.NR_OF_COLUMNS);
	}

	@Test
	public void getColumn() {
		GameBoard gameBoard = new GameBoard();

		assertThat(gameBoard.getColumn(0), empty());

		gameBoard.addPiece(0, RED);
		assertThat(gameBoard.getColumn(0), contains(RED));

		gameBoard.addPiece(0, RED);
		assertThat(gameBoard.getColumn(0), contains(RED, RED));

		gameBoard.addPiece(0, YELLOW);
		assertThat(gameBoard.getColumn(0), contains(RED, RED, YELLOW));

		gameBoard.addPiece(0, RED);
		assertThat(gameBoard.getColumn(0), contains(RED, RED, YELLOW, RED));
	}

	@Test
	public void hasWon_Vertical() {
		GameBoard gameBoard = new GameBoard();

		int columnNr = 0;
		gameBoard.addPiece(columnNr, RED);
		assertThat(gameBoard.hasWon(RED), is(false));
		gameBoard.addPiece(columnNr, RED);
		assertThat(gameBoard.hasWon(RED), is(false));
		gameBoard.addPiece(columnNr, RED);
		assertThat(gameBoard.hasWon(RED), is(false));
		gameBoard.addPiece(columnNr, RED);
		assertThat(gameBoard.hasWon(RED), is(true));
	}

	@Test
	public void hasWon_Vertical_Yellow() {
		GameBoard gameBoard = new GameBoard();

		int columnNr = 0;
		gameBoard.addPiece(columnNr, YELLOW);
		gameBoard.addPiece(columnNr, YELLOW);
		gameBoard.addPiece(columnNr, YELLOW);
		gameBoard.addPiece(columnNr, YELLOW);
		assertThat(gameBoard.hasWon(YELLOW), is(true));
	}

	@Test
	public void hasWon_Vertical_BrokenReds() {
		GameBoard gameBoard = new GameBoard();

		int columnNr = 1;
		gameBoard.addPiece(columnNr, RED);
		gameBoard.addPiece(columnNr, RED);
		gameBoard.addPiece(columnNr, RED);
		gameBoard.addPiece(columnNr, YELLOW);
		gameBoard.addPiece(columnNr, RED);
		assertThat(gameBoard.hasWon(RED), is(false));
	}

	@Test
	public void hasWon_Horizontal() {
		GameBoard gameBoard = new GameBoard();
		for (int i = 1; i <= 5; i++) {
			gameBoard.addPiece(i, YELLOW);
		}

		gameBoard.addPiece(1, RED);
		assertThat(gameBoard.hasWon(RED), is(false));
		gameBoard.addPiece(2, RED);
		assertThat(gameBoard.hasWon(RED), is(false));
		gameBoard.addPiece(3, RED);
		assertThat(gameBoard.hasWon(RED), is(false));
		gameBoard.addPiece(4, RED);
		assertThat(gameBoard.hasWon(RED), is(true));
	}

	@Test
	public void hasWon_Horizontal_Yellow() {
		GameBoard gameBoard = new GameBoard();

		gameBoard.addPiece(1, YELLOW);
		gameBoard.addPiece(2, YELLOW);
		gameBoard.addPiece(3, YELLOW);
		gameBoard.addPiece(4, YELLOW);
		assertThat(gameBoard.hasWon(YELLOW), is(true));
	}

	@Test
	public void hasWon_Diagonally_Red_RightAbove() {
		GameBoard gameBoard = new GameBoard();
		gameBoard.addPiece(1, RED);
		gameBoard.addPiece(2, RED);
		gameBoard.addPiece(3, RED);
		assertThat(gameBoard.hasWon(RED), is(false));
		gameBoard.addPiece(4, YELLOW);
		gameBoard.addPiece(2, RED);
		gameBoard.addPiece(3, YELLOW);
		gameBoard.addPiece(4, RED);
		gameBoard.addPiece(3, RED);
		assertThat(gameBoard.hasWon(RED), is(false));
		gameBoard.addPiece(4, YELLOW);
		assertThat(gameBoard.hasWon(RED), is(false));
		gameBoard.addPiece(4, RED);
		assertThat(gameBoard.hasWon(RED), is(true));
	}

	@Test
	public void hasWon_Diagonally_Red_LeftAbove() {
		GameBoard gameBoard = new GameBoard();
		gameBoard.addPiece(1, YELLOW);
		gameBoard.addPiece(1, YELLOW);
		gameBoard.addPiece(1, YELLOW);
		gameBoard.addPiece(1, RED);
		gameBoard.addPiece(2, YELLOW);
	//	assertThat(gameBoard.hasWon(RED), is(false));
		gameBoard.addPiece(2, YELLOW);
		gameBoard.addPiece(2, RED);
		gameBoard.addPiece(3, RED);
	//	assertThat(gameBoard.hasWon(RED), is(false));
		gameBoard.addPiece(3, RED);
		gameBoard.addPiece(4, RED);
		assertThat(gameBoard.hasWon(RED), is(true));
	}

}