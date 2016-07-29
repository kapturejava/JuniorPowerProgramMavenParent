package be.kapture.connectfour;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UnnameDSoS on 28/07/2016.
 */
class ColourCollector {
	private GameBoard board;

	ColourCollector(GameBoard board) {
		this.board = board;
	}

	List<Colour> getRow(int row) {
		List<Colour> listRow = new ArrayList<>();

		for (int column = 0; column < GameBoard.NR_OF_COLUMNS; column++) {
			listRow.add(board.getColour(column, row));
		}
		return listRow;
	}

	public List<Colour> getColumn(int column) {
		List<Colour> listColumn = new ArrayList<>();

		for (int row = 0; row < GameBoard.NR_OF_ROWS; row++) {
			listColumn.add(board.getColour(column, row));
		}
		return listColumn;
	}

	public List<Colour> getDiagonalToUpperRight(int index) {
		if (index > 0) {
			List<Colour> listColumn = new ArrayList<>();
			for (int diagonalIndex = 0; diagonalIndex < 6 - index + 1; diagonalIndex++) {
				listColumn.add(board.getColour(diagonalIndex + index, diagonalIndex));
			}
			return listColumn;
		} else {
			List<Colour> listColumn = new ArrayList<>();
			for (int diagonalIndex = 0; diagonalIndex < 6 + index; diagonalIndex++) {
				listColumn.add(board.getColour(diagonalIndex, diagonalIndex - index));
			}
			return listColumn;
		}
	}
}
