package be.kapture.chesspuzzle;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cromhjo on 10/05/2016.
 */
public class ChessBoard {

    public List<Tile> doHorseMove(Tile tile) {
        if (tile == null) {
            throw new IllegalArgumentException();
        }
        List<Tile> moves = new ArrayList<>();
        int x = tile.getX();
        int y = tile.getY();

        addOptionalMove(moves, x - 2, y - 1);
        addOptionalMove(moves, x - 1, y - 2);
        addOptionalMove(moves, x - 2, y + 1);
        addOptionalMove(moves, x - 1, y + 2);
        addOptionalMove(moves, x + 2, y - 1);
        addOptionalMove(moves, x + 2, y + 1);
        addOptionalMove(moves, x + 1, y - 2);
        addOptionalMove(moves, x + 1, y + 2);
        return moves;
    }

    private void addOptionalMove(List<Tile> moves, int x1, int y1) {
        if (Tile.isValid(x1, y1)) {
            moves.add(new Tile(x1, y1));
        }
    }
}
