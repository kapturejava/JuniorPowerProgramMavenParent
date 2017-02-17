package be.kapture.chesspuzzle;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cromhjo on 10/05/2016.
 */
public class ChessBoardService {

	static final int NOT_FOUND = -1;
	private final ChessBoard chessBoard;

	public ChessBoardService(ChessBoard chessBoard) {
		this.chessBoard = chessBoard;
	}

	public Collection<Tile> getOccupiedTiles(Tile tile) {
		Set<Tile> occupiedTiles = new HashSet<>();
		return getOccupiedTiles(tile, occupiedTiles);
	}

	private Collection<Tile> getOccupiedTiles(Tile tile, Set<Tile> occupiedTiles) {
		occupiedTiles.add(tile);
		List<Tile> moves = chessBoard.doHorseMove(tile);
		for (Tile t : moves) {
			if (!occupiedTiles.contains(t)) {
				getOccupiedTiles(t, occupiedTiles);
			}
		}
		return occupiedTiles;
	}

	public int getNumberOfMoves(Tile startTile, Tile endTile) {
		if (startTile == null || endTile == null) {
			throw new IllegalArgumentException();
		}

		if (startTile.equals(endTile)) {
			return 0;
		}
		int numberOfMoves = 0;
		Set<Tile> alreadyDoneSet = newHashSet(startTile);
		List<Tile> toDo = newArrayList(startTile);
		do {
			numberOfMoves++;
			List<Tile> todoNext = new ArrayList<>();
			for (Tile tile : toDo) {
				List<Tile> tiles = chessBoard.doHorseMove(tile);
				if (tiles.stream().anyMatch(tile1 -> tile1.equals(endTile))) {
					return numberOfMoves;
				}
				for (Tile tile2 : tiles) {
					if (alreadyDoneSet.add(tile2)) {
						todoNext.add(tile2);
					}
				}
			}
			toDo = todoNext;

		} while (!toDo.isEmpty());
		return NOT_FOUND;
	}

}
