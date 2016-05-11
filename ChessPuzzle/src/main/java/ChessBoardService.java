import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cromhjo on 10/05/2016.
 */
public class ChessBoardService {


    public Collection<Tile> getOccupiedTiles(Tile tile, ChessBoard chessBoard) {
        Set<Tile> occupiedTiles = new HashSet<>();
        //OPTIE 1
        return getOccupiedTiles(tile, chessBoard, occupiedTiles);

        //OPTIE 2
        /*
        occupiedTiles.add(tile);
        Queue<Tile> toProcess = new LinkedList<>();
        Set<Tile> done = new HashSet<>();
        while (tile != null){
            List<Tile> moves = chessBoard.doHorseMove(tile);
            done.add(tile);
            occupiedTiles.addAll(moves);
            for (Tile t: moves) {
                if(!done.contains(t)){
                    toProcess.add(t);
                }
            }
            tile = toProcess.poll();

        }
        return occupiedTiles;
        */
    }

    private Collection<Tile> getOccupiedTiles(Tile tile, ChessBoard chessBoard, Set<Tile> occupiedTiles) {
        occupiedTiles.add(tile);
        List<Tile> moves = chessBoard.doHorseMove(tile);
        for (Tile t: moves){
            if(!occupiedTiles.contains(t)){
                getOccupiedTiles(t,chessBoard, occupiedTiles);
            }
        }
        return occupiedTiles;
    }
}
