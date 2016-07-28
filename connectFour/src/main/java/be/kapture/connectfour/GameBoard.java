package be.kapture.connectfour;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

/**
 * Created by UnnameDSoS on 14/07/2016.
 */
public class GameBoard {
	public static final Predicate<Colour> NOT_NULL = i -> i != null;
	static final int NR_OF_ROWS = 6;
	static final int NR_OF_COLUMNS = 7;
	private final Colour[][] board = new Colour[NR_OF_COLUMNS][NR_OF_ROWS];

	public void addPiece(int column, Colour colour) {
		if (column < 0 || column >= NR_OF_COLUMNS) {
			throw new IllegalArgumentException();
		}

		int nextFreeSpace = getNextFreeSpace(board[column]);
		if (nextFreeSpace == NR_OF_ROWS) {
			throw new IllegalArgumentException();
		}
		board[column][nextFreeSpace] = colour;

	}

	private int getNextFreeSpace(Colour[] colours) {
		int teller = 0;
		while (teller < NR_OF_ROWS && colours[teller] != null) {
			teller++;
		}
		return teller;
	}

	public List<Colour> getColumn(int column) {
		if (column < 0 || column >= NR_OF_COLUMNS) {
			throw new IllegalArgumentException();
		}
		return Arrays.stream(board[column]).filter(NOT_NULL).collect(toList());
	}

	public boolean hasWon(Colour colourToWin) {
		for (Colour[] column : board) {
			if (hasWonVertically(column, colourToWin)) {
				return true;
			}
		}
		for (int row = 0; row < NR_OF_ROWS; row++) {
			if (hasWonHorizontally(colourToWin, row)) return true;
		}
		for (int column = 0; column < NR_OF_COLUMNS; column++) {
			if (hasWonDiagonalUpperRightThatStartsInColumn(colourToWin, column)) return true;
		}
		for (int column = 0; column < NR_OF_COLUMNS; column++) {
			if (hasWonDiagonallyBisectionSecondQuadrant(colourToWin, column)) return true;
		}
		return false;
	}

	private boolean hasWonDiagonallyBisectionSecondQuadrant(Colour colour, int column) {
		int row = 0;
		Colour colour1 = board[column][row];
		while (row < NR_OF_ROWS && colour1 != null) {
			int rowWhile = row;
			int columnWhile = column;
			int amountOfSameColoursFeatured = 0;
			if (rowWhile >= 3) {
				while (rowWhile >= 0 && columnWhile + 1 < NR_OF_COLUMNS && colour1 == colour) {
					amountOfSameColoursFeatured++;
					if (amountOfSameColoursFeatured == 4) {
						return true;
					}
					colour1 = board[++columnWhile][--rowWhile];
				}
			}
			amountOfSameColoursFeatured = 0;
			colour1 = board[column][++row];
		}
		return false;
	}

	private boolean hasWonDiagonalUpperRightThatStartsInColumn(Colour colourToWin, int column) {
		for (int row= 0; row < NR_OF_ROWS; row++){
			if (board[column][row] == null){
				return false;
			}
			if (startsDiagonalWithWinningCombinationOf(colourToWin, column, row)){
				return true;
			}
		}
		return false;
	}

	private boolean startsDiagonalWithWinningCombinationOf(Colour colourToWin, int startColumn, int startRow) {
		int amountOfSameColoursFeatured = 0;
		for (int column =startColumn, row =startRow; stillOnBoard(column, row) ; column++,row++){
			if (board[column][row] != colourToWin ) {
				return false;
			}
			if (++amountOfSameColoursFeatured == 4) {
				return true;
			}

		}

	/*	int rowWhile = startRow;
		int columnWhile = startColumn;
		if (++amountOfSameColoursFeatured == 4) {
			return true;
		}
		while (stillOnBoard(rowWhile, columnWhile) && board[columnWhile][rowWhile] == colourToWin) {
			rowWhile++;
			columnWhile++;
		}*/
		return false;
	}

	private boolean stillOnBoard(int columnWhile, int rowWhile) {
		return rowWhile < NR_OF_ROWS && columnWhile < NR_OF_COLUMNS;
	}

	private boolean hasWonHorizontally(Colour colour, int row) {
		int amountOfSameColoursFeatured = 0;
		for (int column = 0; column < NR_OF_COLUMNS; column++) {
			Colour colour1 = board[column][row];
			if (colour1 == colour) {
				amountOfSameColoursFeatured++;
			} else {
				amountOfSameColoursFeatured = 0;
			}
			if (amountOfSameColoursFeatured == 4) {
				return true;
			}
		}
		return false;
	}

	private boolean hasWonVertically(Colour[] column, Colour colour) {
		int amountOfSameColoursFeatured = 0;
		for (Colour colour1 : column) {
			if (colour1 == null) {
				return false;
			}
			if (colour1 == colour) {
				amountOfSameColoursFeatured++;
			} else {
				amountOfSameColoursFeatured = 0;
			}
			if (amountOfSameColoursFeatured == 4) {
				return true;
			}
		}
		return false;
	}
}